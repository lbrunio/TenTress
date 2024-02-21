package com.example.tentress

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.tentress.model.TreeRepository
import com.example.tentress.ui.theme.TentressTheme
import com.example.tentress.ui.theme.Type

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TentressTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    TreeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreeApp() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TreeTopAppBar()
        }
    ) {
        TreeList(trees = TreeRepository.trees, contentPadding = it)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TreeTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Row {
            Image(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.image_size))
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                painter = painterResource(R.drawable.treelogo),
                contentDescription = null

            )
        }
        Text(
            text = stringResource(id = R.string.top),
            style = Type.roboto
        )
    }, modifier = modifier)
}