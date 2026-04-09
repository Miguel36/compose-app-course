package com.skyfallen.myfirstcomposeapp.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.skyfallen.myfirstcomposeapp.components.MyAdvancedList
import com.skyfallen.myfirstcomposeapp.components.MyBadge
import com.skyfallen.myfirstcomposeapp.components.MyBadgeBox
import com.skyfallen.myfirstcomposeapp.components.MyBasicList
import com.skyfallen.myfirstcomposeapp.components.MyButtons
import com.skyfallen.myfirstcomposeapp.components.MyCard
import com.skyfallen.myfirstcomposeapp.components.MyCheckBox
import com.skyfallen.myfirstcomposeapp.components.MyDateDialog
import com.skyfallen.myfirstcomposeapp.components.MyDialog
import com.skyfallen.myfirstcomposeapp.components.MyDivider
import com.skyfallen.myfirstcomposeapp.components.MyDropDownItem
import com.skyfallen.myfirstcomposeapp.components.MyDropDownMenu
import com.skyfallen.myfirstcomposeapp.components.MyElevatedCard
import com.skyfallen.myfirstcomposeapp.components.MyExposedDropDownMenu
import com.skyfallen.myfirstcomposeapp.components.MyFab
import com.skyfallen.myfirstcomposeapp.components.MyGridList
import com.skyfallen.myfirstcomposeapp.components.MyIcon
import com.skyfallen.myfirstcomposeapp.components.MyImage
import com.skyfallen.myfirstcomposeapp.components.MyLottieAnimationProgress
import com.skyfallen.myfirstcomposeapp.components.MyModalDrawer
import com.skyfallen.myfirstcomposeapp.components.MyNavigationBar
import com.skyfallen.myfirstcomposeapp.components.MyNetworkImage
import com.skyfallen.myfirstcomposeapp.components.MyOutlinedCard
import com.skyfallen.myfirstcomposeapp.components.MyProgress
import com.skyfallen.myfirstcomposeapp.components.MyProgressAdvance
import com.skyfallen.myfirstcomposeapp.components.MyRadioButton
import com.skyfallen.myfirstcomposeapp.components.MyRangeSlider
import com.skyfallen.myfirstcomposeapp.components.MyScrollList
import com.skyfallen.myfirstcomposeapp.components.MySlider
import com.skyfallen.myfirstcomposeapp.components.MySliderAdvanced
import com.skyfallen.myfirstcomposeapp.components.MySwitch
import com.skyfallen.myfirstcomposeapp.components.MyText
import com.skyfallen.myfirstcomposeapp.components.MyTextFieldParent
import com.skyfallen.myfirstcomposeapp.components.MyTimePicker
import com.skyfallen.myfirstcomposeapp.components.MyTopAppBar
import com.skyfallen.myfirstcomposeapp.ui.concepts.advanced.MyDerivedStateOf
import com.skyfallen.myfirstcomposeapp.ui.concepts.advanced.MyInteractionSource
import com.skyfallen.myfirstcomposeapp.ui.concepts.advanced.MyLaunchedEffect
import com.skyfallen.myfirstcomposeapp.components.animations.FullAnimatedAsState
import com.skyfallen.myfirstcomposeapp.components.animations.MyAnimatedContent
import com.skyfallen.myfirstcomposeapp.components.animations.MyAnimatedContentSize
import com.skyfallen.myfirstcomposeapp.components.animations.MyAnimatedVisibility
import com.skyfallen.myfirstcomposeapp.components.animations.MyInfiniteTransition
import com.skyfallen.myfirstcomposeapp.ui.exercises.ConstraintLayoutExercise
import com.skyfallen.myfirstcomposeapp.ui.exercises.RowsColumnsAndBoxExercise
import com.skyfallen.myfirstcomposeapp.ui.exercises.ScaffoldOnlyWithBottomBar
import com.skyfallen.myfirstcomposeapp.ui.concepts.layout.BasicConstraintLayout
import com.skyfallen.myfirstcomposeapp.ui.concepts.layout.ConstraintBarrier
import com.skyfallen.myfirstcomposeapp.ui.concepts.layout.ConstraintChain
import com.skyfallen.myfirstcomposeapp.ui.concepts.layout.ConstraintExampleGuide
import com.skyfallen.myfirstcomposeapp.ui.concepts.layout.MyBox
import com.skyfallen.myfirstcomposeapp.ui.concepts.layout.MyColum
import com.skyfallen.myfirstcomposeapp.ui.concepts.layout.MyComplexLayout
import com.skyfallen.myfirstcomposeapp.ui.concepts.layout.MyRow
import com.skyfallen.myfirstcomposeapp.ui.concepts.navigation.NavigationWrapper
import com.skyfallen.myfirstcomposeapp.ui.HomeScreen
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainNavigationWrapper() {
    val snackBarHostState = remember { SnackbarHostState() }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope() // Se crea corroutina para gestionar en un hilo secundario un proceso
    var fabView by remember { mutableStateOf<(@Composable () -> Unit)?>(null) }

    val navController = rememberNavController()

    MyModalDrawer(drawerState = drawerState, navController = navController) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = { MyTopAppBar { scope.launch { drawerState.open() } } },
            snackbarHost = { SnackbarHost(hostState = snackBarHostState) },
            floatingActionButton = { fabView?.invoke() },
            floatingActionButtonPosition = FabPosition.End,
            bottomBar = { MyNavigationBar() })
        { innerPadding ->

            NavHost(navController = navController, startDestination = Home, modifier = Modifier.padding(innerPadding)) {
                composable<Home> {
                    HomeScreen(navController = navController, snackBarHostState = snackBarHostState) { fabView = it }
                }
                composable<NavigationWrapperExample> {
                    NavigationWrapper()
                }

                composable<MyBoxLayout> { MyBox() }
                composable<MyColumnLayout> { MyColum() }
                composable<MyMixedLayout> { MyComplexLayout() }
                composable<MyRowLayout> { MyRow() }

                composable<MyBasicConstraintLayout> { BasicConstraintLayout() }
                composable<MyGuideLineConstraintLayout> { ConstraintExampleGuide() }
                composable<MyBarrierConstraintLayout> { ConstraintBarrier() }
                composable<MyChainConstraintLayout> { ConstraintChain() }

                composable<RowsColumnsExercise> { RowsColumnsAndBoxExercise() }
                composable<ConstraintsExercise> { ConstraintLayoutExercise() }

                composable<BottomBarScaffold> { ScaffoldOnlyWithBottomBar(snackBarHostState) }

                composable<LaunchedEffectExample> { MyLaunchedEffect {} }
                composable<InteractionSourceExample> { MyInteractionSource() }
                composable<DerivedStateOfExample> { MyDerivedStateOf() }

                composable<NavigationBarComponent> { MyNavigationBar() }
                composable<TopAppBarComponent> { MyTopAppBar {} }
                composable<DividerComponent> { MyDivider() }
                composable<BasicListComponent> { MyBasicList() }
                composable<AdvancedListComponent> { MyAdvancedList() }
                composable<ScrollListComponent> { MyScrollList() }
                composable<GridListComponent> { MyGridList() }
                composable<TextComponent> { MyText() }
                composable<TextFieldComponent> { MyTextFieldParent() }
                composable<ButtonComponent> { MyButtons() }
                composable<FabComponent> { MyFab() }
                composable<ImageComponent> { MyImage() }
                composable<NetworkImageComponent> { MyNetworkImage() }
                composable<IconComponent> { MyIcon() }
                composable<CardComponent> { MyCard() }
                composable<ElevatedCardComponent> { MyElevatedCard() }
                composable<OutlinedCardComponent> { MyOutlinedCard() }
                composable<ProgressComponent> { MyProgress() }
                composable<ProgressAdvanceComponent> { MyProgressAdvance() }
                composable<LottieAnimationProgressComponent> { MyLottieAnimationProgress() }
                composable<CheckBoxComponent> { MyCheckBox() }
                composable<RadioButtonComponent> { MyRadioButton() }
                composable<SliderComponent> { MySlider() }
                composable<SliderAdvanceComponent> { MySliderAdvanced() }
                composable<RangeSliderComponent> { MyRangeSlider() }
                composable<BadgeComponent> { MyBadge() }
                composable<BadgeBoxComponent> { MyBadgeBox() }
                composable<ExposedDropDownComponent> { MyExposedDropDownMenu() }
                composable<DropDownMenuComponent> { MyDropDownMenu() }
                composable<DropDownItemComponent> { MyDropDownItem() }
                composable<ToggleControlComponent> { MySwitch() }
                composable<BasicDialogComponent> { MyDialog() }
                composable<DateDialogComponent> { MyDateDialog() }
                composable<TimePickerDialogComponent> { MyTimePicker() }
                composable<AnimatedVisibility> { MyAnimatedVisibility() }
                composable<AnimatedAsState> { FullAnimatedAsState() }
                composable<AnimatedContent> { MyAnimatedContent() }
                composable<AnimatedContentSize> { MyAnimatedContentSize() }
                composable<InfiniteTransition> { MyInfiniteTransition() }
            }
        }
    }


}