package com.example.tentress

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tentress.model.Tree
import com.example.tentress.model.TreeRepository
import com.example.tentress.ui.theme.Type
import com.example.tentress.ui.theme.DarkColors
import com.example.tentress.ui.theme.LightColors
import com.example.tentress.ui.theme.md_theme_dark_inversePrimary
import com.example.tentress.ui.theme.md_theme_dark_inverseSurface
import com.example.tentress.ui.theme.md_theme_light_secondary
import com.example.tentress.ui.theme.md_theme_light_tertiary


@Composable
fun TreeItem(
    tree: Tree,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    val color by animateColorAsState(
        targetValue = if (expanded) md_theme_dark_inversePrimary else md_theme_light_tertiary,
    )
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMedium
                    )
                )
                .background(color = color)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ) {
                TreeIcon(tree.imageRes)
                Spacer(modifier = Modifier.width(16.dp))
                TreeName(tree.nameRes)
                Spacer(modifier = Modifier.weight(1f))
                TreeItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            if (expanded) {
                TreeInformation(
                    tree.descriptionRes,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 8.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                )
            }
        }
    }
}

@Composable
fun TreeIcon(
    @DrawableRes treeIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(48.dp)
            .clip(MaterialTheme.shapes.medium),
        contentScale = ContentScale.Crop,
        painter = painterResource(treeIcon),
        contentDescription = null
    )
}

@Composable
fun TreeName(
    @StringRes treeInfo: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(treeInfo),
            style = Type.roboto,

        )
    }
}


@Composable
private fun TreeItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_button_content_description),
            tint = md_theme_dark_inverseSurface
        )
    }
}


@Composable
fun TreeInformation(
    @StringRes treeInfo: Int,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(treeInfo),
            style = Type.ptserif
        )
    }
}


@Composable
fun TreeList(
    trees: List<Tree>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyColumn(contentPadding = contentPadding) {
        items(trees) { tree ->
            TreeItem(
                tree = tree,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun DaysAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}

@Preview
@Composable
fun TreesDarkPreview() {
    DaysAppTheme(darkTheme = true) {
        Surface(
            color = DarkColors.background
        ) {
            TreeList(trees = TreeRepository.trees)
        }
    }
}

@Preview
@Composable
fun TreesLightPreview() {
    DaysAppTheme(darkTheme = false) {
        Surface(
            color = LightColors.background
        ) {
            TreeList(trees = TreeRepository.trees)
        }
    }
}
