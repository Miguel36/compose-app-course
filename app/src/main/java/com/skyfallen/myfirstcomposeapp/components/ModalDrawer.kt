package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.skyfallen.myfirstcomposeapp.model.MenuItem
import com.skyfallen.myfirstcomposeapp.model.menuItems
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(drawerState: DrawerState, navController: NavHostController, content: @Composable () -> Unit) {

    val scope = rememberCoroutineScope()
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    val listState = rememberLazyListState()

    // Container del navigationDrawer
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Menu desplegable (navigation-drawer)
            ModalDrawerSheet(
                drawerShape = RoundedCornerShape(topEndPercent = 4, bottomEndPercent = 4),
                drawerContentColor = Color.Red.copy(0.80f),
                drawerContainerColor = Color.White,
            ) {
                // Add Scroll to Menu Drawer
                LazyColumn(state = listState) {
                    item { Spacer(Modifier.height(30.dp)) }

                    itemsIndexed(menuItems) { index, menuItem ->
                        MyMenuItem(index == selectedIndex, menuItem) {
                            selectedIndex = index

                            scope.launch { drawerState.close() }
                            navController.navigate(menuItem.route)
                        }
                    }
                }


            }
        },
        scrimColor = Color.Black.copy(alpha = 0.70f)
    ) {
        content()
    }
}

@Composable
fun MyMenuItem(isMenuItemSelected: Boolean, menuItem: MenuItem, onItemSelected: () -> Unit) {
    NavigationDrawerItem(
        label = { Text(text = menuItem.text) },
        selected = isMenuItemSelected,
        onClick = { onItemSelected() },
        icon = { Icon(imageVector = menuItem.icon, contentDescription = "") },
        badge = {
            if (menuItem.notificationsNumber > 0)
                Badge(
                    containerColor = if (isMenuItemSelected) Color.Blue else Color.White,
                    contentColor = if (isMenuItemSelected) Color.White else Color.Blue
                ) {
                    Text(text = menuItem.notificationsNumber.toString())
                }
        },
        shape = RoundedCornerShape(4),
        colors = NavigationDrawerItemDefaults.colors(
            selectedContainerColor = Color.Blue.copy(0.15f),
            selectedTextColor = Color.Blue,
            selectedIconColor = Color.Black,
            selectedBadgeColor = Color.White,
            unselectedContainerColor = Color.Blue.copy(0.02f),
            unselectedTextColor = Color.Black,
            unselectedIconColor = Color.Blue
        )
    )
}