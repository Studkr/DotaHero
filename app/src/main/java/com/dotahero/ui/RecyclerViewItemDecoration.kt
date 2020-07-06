package com.dotahero.ui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.dotahero.utils.dp

class RecyclerViewItemDecoration(val offset: Int) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.bottom = offset.dp
        outRect.right = offset.dp
        outRect.left = offset.dp
        outRect.top = offset.dp
    }
}