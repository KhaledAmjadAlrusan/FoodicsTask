package com.foodics.presentation.component.search

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.foodics.presentation.shared.theme.FoodicsColor

@Composable
fun CustomSearchBar(
    placeholder: String,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var searchText by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(FoodicsColor.background)
            .padding(horizontal = 16.dp)
            .height(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                BorderStroke(1.dp, FoodicsColor.border),
                shape = RoundedCornerShape(16.dp)
            ),
        color = FoodicsColor.background
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = FoodicsColor.primaryColor,
                modifier = Modifier.size(24.dp)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                if (searchText.isEmpty()) {
                    Text(
                        text = placeholder,
                        color = FoodicsColor.disabledColor
                    )
                }
                BasicTextField(
                    value = searchText,
                    onValueChange = { newText ->
                        searchText = newText
                        onSearch(newText)
                    },
                    singleLine = true,
                    textStyle = LocalTextStyle.current.copy(color = FoodicsColor.textColor),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    ),
                    modifier = Modifier.fillMaxWidth()
                )
            }
            if (searchText.isNotEmpty()) {
                IconButton(
                    onClick = {
                        searchText = ""
                        onSearch("")
                        keyboardController?.hide()
                        focusManager.clearFocus()
                    },
                    modifier = Modifier.size(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear Text",
                        tint = FoodicsColor.textColor
                    )
                }
            }
        }
    }
}

