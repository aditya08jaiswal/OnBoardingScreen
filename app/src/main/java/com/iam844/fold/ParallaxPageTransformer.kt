package com.iam844.fold

import android.util.SparseArray
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import java.util.*

class ParallaxPageTransformer: ViewPager2.PageTransformer {
    companion object {
        private const val FOREGROUND_FACTOR = 0.5f
    }

    private val cache = WeakHashMap<View, ViewMappings>()

    override fun transformPage(page: View, position: Float) {
        val offset = page.width * position
        page.getMappings().also { mappings ->
//            mappings[R.id.imageOnboardingIconRight]?.translationX = -offset
            mappings[R.id.imageOnboardingIconRight]?.translationX = offset * FOREGROUND_FACTOR
            mappings[R.id.imageOnboardingIconCenter]?.translationX = offset * FOREGROUND_FACTOR
            mappings[R.id.imageOnboardingIconLeft]?.translationX = offset * FOREGROUND_FACTOR
        }
    }

    private fun View.getMappings(): ViewMappings =
        cache[this] ?: ViewMappings().also { mappings ->
            mappings.put(R.id.imageOnboardingIconCenter, findViewById(R.id.imageOnboardingIconCenter))
            mappings.put(R.id.imageOnboardingIconRight, findViewById(R.id.imageOnboardingIconRight))
            mappings.put(R.id.imageOnboardingIconLeft, findViewById(R.id.imageOnboardingIconLeft))
            cache[this] = mappings
        }

    private class ViewMappings : SparseArray<View>()
}