package com.skyfallen.myfirstcomposeapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

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
            Row(Modifier.fillMaxWidth().padding(vertical = 12.dp), horizontalArrangement = Arrangement.Center) {
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
        itemsIndexed(itemList, key = {_, item -> item}) { index, item ->
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