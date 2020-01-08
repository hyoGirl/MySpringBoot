package com.mybatis.plus.controller;

import com.alibaba.fastjson.JSON;
import com.mybatis.plus.entity.SysMenu;
import com.mybatis.plus.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ashura1110
 * @ClassName XULEI
 * @description TODO
 * @Date 2019/11/26 22:29
 * @Version 1.0
 */
@Controller
public class MenuController {



    @Autowired
    MenuService menuService;

    @GetMapping("/menu")
    @ResponseBody
    public Object get(){


        List<SysMenu> sysMenus = menuService.list();

        System.out.println(JSON.toJSON(sysMenus));

        List<SysMenu> sysMenus1 = treeBuilder(sysMenus);

        System.out.println();
        System.out.println(JSON.toJSON(sysMenus));

        return null;
    }


    public static List<SysMenu> treeBuilder(List<SysMenu> sysMenus) {

        List<SysMenu> menuList = new ArrayList<SysMenu>();

        // 先找到一级菜单
        for (SysMenu sysMenu : sysMenus) {
            if (-1L== sysMenu.getParentId()) {
                menuList.add(sysMenu);
            }
//            for (SysMenu menu : sysMenus) {
//                if (menu.getParentId().equals(sysMenu.getId())) {
//                    if (sysMenu.getSubMenus() == null) {
//                        sysMenu.setSubMenus(new ArrayList<>());
//                    }
//                    sysMenu.getSubMenus().add(menu);
//                }
//            }
        }

        // 为一级菜单设置子菜单，getChild是递归调用的
        for(SysMenu sysMenu : menuList){
            sysMenu.setSubMenus(getChild(sysMenu.getId(),sysMenus));
        }



        return menuList;
    }

    private static List<SysMenu> getChild(Long id, List<SysMenu> rootMenu) {


        List<SysMenu> childList = new ArrayList<>();

        for (SysMenu sysMenu : rootMenu) {

            if (-1 != sysMenu.getParentId()) {

                if (sysMenu.getParentId().equals(id)) {
                    childList.add(sysMenu);
                }
            }
        }

        // 把子菜单的子菜单再循环一遍
        for (SysMenu menu : childList) {// 没有url子菜单还有子菜单
            if (StringUtils.isEmpty(menu.getPath())) {
                menu.setSubMenus(getChild(menu.getId(), rootMenu));
            }
        } // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }

        return childList;
    }
}
