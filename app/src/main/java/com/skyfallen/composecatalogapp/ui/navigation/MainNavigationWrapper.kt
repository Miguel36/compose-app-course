package com.skyfallen.composecatalogapp.ui.navigation

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
import com.skyfallen.composecatalogapp.components.MyAdvancedList
import com.skyfallen.composecatalogapp.components.MyBadge
import com.skyfallen.composecatalogapp.components.MyBadgeBox
import com.skyfallen.composecatalogapp.components.MyBasicList
import com.skyfallen.composecatalogapp.components.MyButtons
import com.skyfallen.composecatalogapp.components.MyCard
import com.skyfallen.composecatalogapp.components.MyCheckBox
import com.skyfallen.composecatalogapp.components.MyDateDialog
import com.skyfallen.composecatalogapp.components.MyDialog
import com.skyfallen.composecatalogapp.components.MyDivider
import com.skyfallen.composecatalogapp.components.MyDropDownItem
import com.skyfallen.composecatalogapp.components.MyDropDownMenu
import com.skyfallen.composecatalogapp.components.MyElevatedCard
import com.skyfallen.composecatalogapp.components.MyExposedDropDownMenu
import com.skyfallen.composecatalogapp.components.MyFab
import com.skyfallen.composecatalogapp.components.MyGridList
import com.skyfallen.composecatalogapp.components.MyIcon
import com.skyfallen.composecatalogapp.components.MyImage
import com.skyfallen.composecatalogapp.components.MyLottieAnimationProgress
import com.skyfallen.composecatalogapp.components.MyModalDrawer
import com.skyfallen.composecatalogapp.components.MyNavigationBar
import com.skyfallen.composecatalogapp.components.MyNetworkImage
import com.skyfallen.composecatalogapp.components.MyOutlinedCard
import com.skyfallen.composecatalogapp.components.MyProgress
import com.skyfallen.composecatalogapp.components.MyProgressAdvance
import com.skyfallen.composecatalogapp.components.MyRadioButton
import com.skyfallen.composecatalogapp.components.MyRangeSlider
import com.skyfallen.composecatalogapp.components.MyScrollList
import com.skyfallen.composecatalogapp.components.MySlider
import com.skyfallen.composecatalogapp.components.MySliderAdvanced
import com.skyfallen.composecatalogapp.components.MySwitch
import com.skyfallen.composecatalogapp.components.MyText
import com.skyfallen.composecatalogapp.components.MyTextFieldParent
import com.skyfallen.composecatalogapp.components.MyTimePicker
import com.skyfallen.composecatalogapp.components.MyTopAppBar
import com.skyfallen.composecatalogapp.ui.concepts.advanced.MyDerivedStateOf
import com.skyfallen.composecatalogapp.ui.concepts.advanced.MyInteractionSource
import com.skyfallen.composecatalogapp.ui.concepts.advanced.MyLaunchedEffect
import com.skyfallen.composecatalogapp.components.animations.FullAnimatedAsState
import com.skyfallen.composecatalogapp.components.animations.MyAnimatedContent
import com.skyfallen.composecatalogapp.components.animations.MyAnimatedContentSize
import com.skyfallen.composecatalogapp.components.animations.MyAnimatedVisibility
import com.skyfallen.composecatalogapp.components.animations.MyInfiniteTransition
import com.skyfallen.composecatalogapp.ui.exercises.ConstraintLayoutExercise
import com.skyfallen.composecatalogapp.ui.exercises.RowsColumnsAndBoxExercise
import com.skyfallen.composecatalogapp.ui.exercises.ScaffoldOnlyWithBottomBar
import com.skyfallen.composecatalogapp.ui.concepts.layout.BasicConstraintLayout
import com.skyfallen.composecatalogapp.ui.concepts.layout.ConstraintBarrier
import com.skyfallen.composecatalogapp.ui.concepts.layout.ConstraintChain
import com.skyfallen.composecatalogapp.ui.concepts.layout.ConstraintExampleGuide
import com.skyfallen.composecatalogapp.ui.concepts.layout.MyBox
import com.skyfallen.composecatalogapp.ui.concepts.layout.MyColum
import com.skyfallen.composecatalogapp.ui.concepts.layout.MyComplexLayout
import com.skyfallen.composecatalogapp.ui.concepts.layout.MyRow
import com.skyfallen.composecatalogapp.ui.concepts.navigation.NavigationWrapper
import com.skyfallen.composecatalogapp.ui.HomeScreen
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