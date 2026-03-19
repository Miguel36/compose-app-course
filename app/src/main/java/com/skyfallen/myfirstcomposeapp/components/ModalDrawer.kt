package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
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
import com.skyfallen.myfirstcomposeapp.components.model.MenuItem
import com.skyfallen.myfirstcomposeapp.ui.navigation.BottomBarScaffold
import com.skyfallen.myfirstcomposeapp.ui.navigation.ConstraintsExercise
import com.skyfallen.myfirstcomposeapp.ui.navigation.DerivedStateOfExample
import com.skyfallen.myfirstcomposeapp.ui.navigation.Home
import com.skyfallen.myfirstcomposeapp.ui.navigation.InteractionSourceExample
import com.skyfallen.myfirstcomposeapp.ui.navigation.LaunchedEffectExample
import com.skyfallen.myfirstcomposeapp.ui.navigation.MyBarrierConstraintLayout
import com.skyfallen.myfirstcomposeapp.ui.navigation.MyBasicConstraintLayout
import com.skyfallen.myfirstcomposeapp.ui.navigation.MyBoxLayout
import com.skyfallen.myfirstcomposeapp.ui.navigation.MyChainConstraintLayout
import com.skyfallen.myfirstcomposeapp.ui.navigation.MyColumnLayout
import com.skyfallen.myfirstcomposeapp.ui.navigation.MyGuideLineConstraintLayout
import com.skyfallen.myfirstcomposeapp.ui.navigation.MyMixedLayout
import com.skyfallen.myfirstcomposeapp.ui.navigation.MyRowLayout
import com.skyfallen.myfirstcomposeapp.ui.navigation.NavigationWrapperExample
import com.skyfallen.myfirstcomposeapp.ui.navigation.RowsColumnsExercise
import kotlinx.coroutines.launch

@Composable
fun MyModalDrawer(drawerState: DrawerState, navController: NavHostController, content: @Composable () -> Unit) {

    val scope = rememberCoroutineScope()
    var selectedIndex by rememberSaveable { mutableIntStateOf(0) }
    val listState = rememberLazyListState()

    val menuItems = listOf(
        MenuItem(Icons.Default.Home, "Home", 3, Home),
        MenuItem(Icons.Default.Search, "ExampleNavigation", 0, NavigationWrapperExample),

        MenuItem(Icons.Default.CheckCircle, "MyBox - Layout", 0, MyBoxLayout),
        MenuItem(Icons.Default.CheckCircle, "MyColum - Layout", 0, MyColumnLayout),
        MenuItem(Icons.Default.CheckCircle, "MyMixed - Layout", 0, MyMixedLayout),
        MenuItem(Icons.Default.CheckCircle, "MyRow - Layout", 0, MyRowLayout),
        MenuItem(Icons.Default.CheckCircle, "MyBasicConstraint - Layout", 0, MyBasicConstraintLayout),
        MenuItem(Icons.Default.CheckCircle, "MyGuideLineConstraint - Layout", 0, MyGuideLineConstraintLayout),
        MenuItem(Icons.Default.CheckCircle, "MyBarrierConstraint - Layout", 0, MyBarrierConstraintLayout),
        MenuItem(Icons.Default.CheckCircle, "MyChainConstraint - Layout", 0, MyChainConstraintLayout),
        MenuItem(Icons.Default.CheckCircle, "RowColumns - Exercise", 0, RowsColumnsExercise),
        MenuItem(Icons.Default.CheckCircle, "ConstraintLayout - Exercise", 0, ConstraintsExercise),
        MenuItem(Icons.Default.CheckCircle, "BottomBarScaffold - Exercise", 0, BottomBarScaffold),
        MenuItem(Icons.Default.CheckCircle, "LaunchedEffect - Example", 0, LaunchedEffectExample),
        MenuItem(Icons.Default.CheckCircle, "InteractionSource - Example", 0, InteractionSourceExample),
        MenuItem(Icons.Default.CheckCircle, "DerivedStateOf - Example", 0, DerivedStateOfExample),
    )

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