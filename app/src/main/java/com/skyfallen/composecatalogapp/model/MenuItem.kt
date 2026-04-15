package com.skyfallen.composecatalogapp.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.ui.graphics.vector.ImageVector
import com.skyfallen.composecatalogapp.ui.navigation.AdvancedListComponent
import com.skyfallen.composecatalogapp.ui.navigation.AnimatedAsState
import com.skyfallen.composecatalogapp.ui.navigation.AnimatedContent
import com.skyfallen.composecatalogapp.ui.navigation.AnimatedContentSize
import com.skyfallen.composecatalogapp.ui.navigation.AnimatedVisibility
import com.skyfallen.composecatalogapp.ui.navigation.BadgeBoxComponent
import com.skyfallen.composecatalogapp.ui.navigation.BadgeComponent
import com.skyfallen.composecatalogapp.ui.navigation.BasicDialogComponent
import com.skyfallen.composecatalogapp.ui.navigation.BasicListComponent
import com.skyfallen.composecatalogapp.ui.navigation.BottomBarScaffold
import com.skyfallen.composecatalogapp.ui.navigation.ButtonComponent
import com.skyfallen.composecatalogapp.ui.navigation.CardComponent
import com.skyfallen.composecatalogapp.ui.navigation.CheckBoxComponent
import com.skyfallen.composecatalogapp.ui.navigation.ConstraintsExercise
import com.skyfallen.composecatalogapp.ui.navigation.DateDialogComponent
import com.skyfallen.composecatalogapp.ui.navigation.DerivedStateOfExample
import com.skyfallen.composecatalogapp.ui.navigation.DividerComponent
import com.skyfallen.composecatalogapp.ui.navigation.DropDownItemComponent
import com.skyfallen.composecatalogapp.ui.navigation.DropDownMenuComponent
import com.skyfallen.composecatalogapp.ui.navigation.ElevatedCardComponent
import com.skyfallen.composecatalogapp.ui.navigation.ExposedDropDownComponent
import com.skyfallen.composecatalogapp.ui.navigation.FabComponent
import com.skyfallen.composecatalogapp.ui.navigation.GridListComponent
import com.skyfallen.composecatalogapp.ui.navigation.Home
import com.skyfallen.composecatalogapp.ui.navigation.IconComponent
import com.skyfallen.composecatalogapp.ui.navigation.ImageComponent
import com.skyfallen.composecatalogapp.ui.navigation.InfiniteTransition
import com.skyfallen.composecatalogapp.ui.navigation.InteractionSourceExample
import com.skyfallen.composecatalogapp.ui.navigation.LaunchedEffectExample
import com.skyfallen.composecatalogapp.ui.navigation.LottieAnimationProgressComponent
import com.skyfallen.composecatalogapp.ui.navigation.MyBarrierConstraintLayout
import com.skyfallen.composecatalogapp.ui.navigation.MyBasicConstraintLayout
import com.skyfallen.composecatalogapp.ui.navigation.MyBoxLayout
import com.skyfallen.composecatalogapp.ui.navigation.MyChainConstraintLayout
import com.skyfallen.composecatalogapp.ui.navigation.MyColumnLayout
import com.skyfallen.composecatalogapp.ui.navigation.MyGuideLineConstraintLayout
import com.skyfallen.composecatalogapp.ui.navigation.MyMixedLayout
import com.skyfallen.composecatalogapp.ui.navigation.MyRowLayout
import com.skyfallen.composecatalogapp.ui.navigation.NavigationBarComponent
import com.skyfallen.composecatalogapp.ui.navigation.NavigationWrapperExample
import com.skyfallen.composecatalogapp.ui.navigation.NetworkImageComponent
import com.skyfallen.composecatalogapp.ui.navigation.OutlinedCardComponent
import com.skyfallen.composecatalogapp.ui.navigation.ProgressAdvanceComponent
import com.skyfallen.composecatalogapp.ui.navigation.ProgressComponent
import com.skyfallen.composecatalogapp.ui.navigation.RadioButtonComponent
import com.skyfallen.composecatalogapp.ui.navigation.RangeSliderComponent
import com.skyfallen.composecatalogapp.ui.navigation.RowsColumnsExercise
import com.skyfallen.composecatalogapp.ui.navigation.ScrollListComponent
import com.skyfallen.composecatalogapp.ui.navigation.SliderAdvanceComponent
import com.skyfallen.composecatalogapp.ui.navigation.SliderComponent
import com.skyfallen.composecatalogapp.ui.navigation.TextComponent
import com.skyfallen.composecatalogapp.ui.navigation.TextFieldComponent
import com.skyfallen.composecatalogapp.ui.navigation.TimePickerDialogComponent
import com.skyfallen.composecatalogapp.ui.navigation.ToggleControlComponent
import com.skyfallen.composecatalogapp.ui.navigation.TopAppBarComponent

data class MenuItem(
    val icon: ImageVector,
    val text: String,
    val notificationsNumber: Int,
    val route: Any
)

val menuItems = listOf(
    MenuItem(Icons.Default.Home, "Home", 3, Home),
    MenuItem(Icons.Default.Search, "ExampleNavigation", 0, NavigationWrapperExample),

    MenuItem(Icons.Default.Check, "MyBox - Layout", 0, MyBoxLayout),
    MenuItem(Icons.Default.Check, "MyColum - Layout", 0, MyColumnLayout),
    MenuItem(Icons.Default.Check, "MyMixed - Layout", 0, MyMixedLayout),
    MenuItem(Icons.Default.Check, "MyRow - Layout", 0, MyRowLayout),
    MenuItem(Icons.Default.Check, "MyBasicConstraint - Layout", 0, MyBasicConstraintLayout),
    MenuItem(Icons.Default.Check, "MyGuideLineConstraint - Layout", 0, MyGuideLineConstraintLayout),
    MenuItem(Icons.Default.Check, "MyBarrierConstraint - Layout", 0, MyBarrierConstraintLayout),
    MenuItem(Icons.Default.Check, "MyChainConstraint - Layout", 0, MyChainConstraintLayout),
    MenuItem(Icons.Default.ThumbUp, "RowColumns - Exercise", 0, RowsColumnsExercise),
    MenuItem(Icons.Default.ThumbUp, "ConstraintLayout - Exercise", 0, ConstraintsExercise),
    MenuItem(Icons.Default.ThumbUp, "BottomBarScaffold - Exercise", 0, BottomBarScaffold),
    MenuItem(Icons.Default.FavoriteBorder, "LaunchedEffect - Example", 0, LaunchedEffectExample),
    MenuItem(Icons.Default.FavoriteBorder, "InteractionSource - Example", 0, InteractionSourceExample),
    MenuItem(Icons.Default.FavoriteBorder, "DerivedStateOf - Example", 0, DerivedStateOfExample),
    MenuItem(Icons.Default.Star, "NavigationBar - Component", 0, NavigationBarComponent),
    MenuItem(Icons.Default.Star, "TopAppBar - Component", 0, TopAppBarComponent),
    MenuItem(Icons.Default.Star, "Divider - Component", 0, DividerComponent),
    MenuItem(Icons.Default.Star, "BasicList - Component", 0, BasicListComponent),
    MenuItem(Icons.Default.Star, "AdvancedList - Component", 0, AdvancedListComponent),
    MenuItem(Icons.Default.Star, "ScrollList - Component", 0, ScrollListComponent),
    MenuItem(Icons.Default.Star, "GridList - Component", 0, GridListComponent),
    MenuItem(Icons.Default.Star, "Text - Component", 0, TextComponent),
    MenuItem(Icons.Default.Star, "TextField - Component", 0, TextFieldComponent),
    MenuItem(Icons.Default.Star, "Button - Component", 0, ButtonComponent),
    MenuItem(Icons.Default.Star, "Fab - Component", 0, FabComponent),
    MenuItem(Icons.Default.Star, "Image - Component", 0, ImageComponent),
    MenuItem(Icons.Default.Star, "NetworkImage - Component", 0, NetworkImageComponent),
    MenuItem(Icons.Default.Star, "Icon - Component", 0, IconComponent),
    MenuItem(Icons.Default.Star, "Card - Component", 0, CardComponent),
    MenuItem(Icons.Default.Star, "ElevatedCard - Component", 0, ElevatedCardComponent),
    MenuItem(Icons.Default.Star, "OutlinedCard - Component", 0, OutlinedCardComponent),
    MenuItem(Icons.Default.Star, "Progress - Component", 0, ProgressComponent),
    MenuItem(Icons.Default.Star, "ProgressAdvance - Component", 0, ProgressAdvanceComponent),
    MenuItem(Icons.Default.Star, "LottieAnimationProgress - Component", 0, LottieAnimationProgressComponent),
    MenuItem(Icons.Default.Star, "CheckBox - Component", 0, CheckBoxComponent),
    MenuItem(Icons.Default.Star, "RadioButton - Component", 0, RadioButtonComponent),
    MenuItem(Icons.Default.Star, "Slider - Component", 0, SliderComponent),
    MenuItem(Icons.Default.Star, "SliderAdvanced - Component", 0, SliderAdvanceComponent),
    MenuItem(Icons.Default.Star, "RangeSlider - Component", 0, RangeSliderComponent),
    MenuItem(Icons.Default.Star, "Badge - Component", 0, BadgeComponent),
    MenuItem(Icons.Default.Star, "BadgeBox - Component", 0, BadgeBoxComponent),
    MenuItem(Icons.Default.Star, "ExposedDropDown - Component", 0, ExposedDropDownComponent),
    MenuItem(Icons.Default.Star, "DropDownMenu - Component", 0, DropDownMenuComponent),
    MenuItem(Icons.Default.Star, "DropDownItem - Component", 0, DropDownItemComponent),
    MenuItem(Icons.Default.Star, "ToggleControl - Component", 0, ToggleControlComponent),
    MenuItem(Icons.Default.Star, "BasicDialog - Component", 0, BasicDialogComponent),
    MenuItem(Icons.Default.Star, "DateDialog - Component", 0, DateDialogComponent),
    MenuItem(Icons.Default.Star, "TimePickerDialog - Component", 0, TimePickerDialogComponent),
    MenuItem(Icons.Default.PlayArrow, "Animated - Visibility", 0, AnimatedVisibility),
    MenuItem(Icons.Default.PlayArrow, "Animated - AsState", 0, AnimatedAsState),
    MenuItem(Icons.Default.PlayArrow, "Animated - Content", 0, AnimatedContent),
    MenuItem(Icons.Default.PlayArrow, "Animated - ContentSize", 0, AnimatedContentSize),
    MenuItem(Icons.Default.PlayArrow, "Animation - InfiniteTransition", 0, InfiniteTransition)
)
