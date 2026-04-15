package com.skyfallen.composecatalogapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random


/**
 * LazyColum or LazyRow vendría siendo el nuevo componente usado en jetpack compose para reemplazar
 * el recyclerView. El cuál es muchísimo más optimizado y más simple
 */
@Composable
fun MyBasicList(modifier: Modifier = Modifier) {

    val nameList = listOf("Miguel", "Jose", "Daniela", "Pepe", "Matias", "Jesús")

    LazyColumn(modifier = modifier.padding(vertical = 12.dp)) {
        items(nameList) {
            Text(it, modifier = Modifier.background(Color.Yellow))
        }
    }
}

@Composable
fun MyAdvancedList(modifier: Modifier = Modifier) {
    var itemList by remember {
        mutableStateOf(
            List(100) {
                "Item número $it"
            })
    }

    LazyColumn(modifier = modifier.padding(horizontal = 16.dp)) {
        item {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp), horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    itemList = itemList.toMutableList().apply {
                        add(0, "Holaaa + ${itemList.size + 1}")
                    }
                }) {
                    Text(text = "Add element")
                }
            }
        }

        /**
         * key parameter is necessary for optimizing the list, this value has to be unique.
         */
        itemsIndexed(itemList, key = { _, item -> item }) { index, item ->
            Row {
                Text(text = "$item,  indice: $index")
                Spacer(Modifier.weight(1f))
                TextButton(onClick = {
                    itemList = itemList.toMutableList().apply {
                        remove(item)
                        //removeAt(index)
                    }
                }) { Text(text = "Delete") }
            }
        }
    }
}

@Composable
fun MyScrollList(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 10
        }
    }

    Box(Modifier.fillMaxSize()) {
        LazyColumn(state = listState) {
            /**
             * If you put a number in items method, it will create n views
             */
            items(100) {
                Text(
                    text = "item: $it",
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )
            }
        }
        if (showButton) {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        listState.animateScrollToItem(0)
                        //listState.scrollToItem(0)
                    }
                },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 4.dp)
                    .size(30.dp)
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = null)
            }
        }
    }
}

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    val numbers = remember { mutableStateOf(List(50) { Random.nextInt(0, 6) }) }
    val colors = listOf(
        Color(0xFFFF6B6B),
        Color(0xFFFFA41B),
        Color(0xFF51CF66),
        Color(0xFF1AC8ED),
        Color(0xFF9D4EDD),
        Color(0xFFFF4DA6)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16 .dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(numbers.value) { randomNumber ->
            Box(
                modifier = Modifier.background(colors[randomNumber]).height(90.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(randomNumber.toString(), color = Color.White, fontSize = 20.sp)
            }
        }
    }
}