package com.example.tentress.model

import com.example.tentress.R

class TreeRepository {
    companion object {
        val trees: List<Tree> = listOf(
            Tree(
                nameRes = R.string.cherry_tree,
                descriptionRes = R.string.cherry_desc,
                imageRes = R.drawable.cherryblossomstree
            ),
            Tree(
                nameRes = R.string.red_maple_tree,
                descriptionRes = R.string.red_desc,
                imageRes = R.drawable.redmapletree
            ),
            Tree(
                nameRes = R.string.maple_tree,
                descriptionRes = R.string.maple_desc,
                imageRes = R.drawable.mapletree
            ),
            Tree(
                nameRes = R.string.black_willow_tree,
                descriptionRes = R.string.black_desc,
                imageRes = R.drawable.blackwillowtree
            ),
            Tree(
                nameRes = R.string.dragon_tree,
                descriptionRes = R.string.dragon_desc,
                imageRes = R.drawable.dragonbloodtree
            ),
            Tree(
                nameRes = R.string.angle_oak_tree,
                descriptionRes = R.string.angle_desc,
                imageRes = R.drawable.quercusvirginiana
            ),
            Tree(
                nameRes = R.string.oak_tree,
                descriptionRes = R.string.oak_desc,
                imageRes = R.drawable.oaktree
            ),
            Tree(
                nameRes = R.string.pine_tree,
                descriptionRes = R.string.pine_desc,
                imageRes = R.drawable.pinetree
            ),
            Tree(
                nameRes = R.string.birch_tree,
                descriptionRes = R.string.birch_desc,
                imageRes = R.drawable.birchtree
            ),
            Tree(
                nameRes = R.string.cedar_elm_tree,
                descriptionRes = R.string.cedar_desc,
                imageRes = R.drawable.cedarelmtree
            )
        )
    }
}