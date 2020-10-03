package com.iam844.fold

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OnBoardingAdapter(private val onBoardingItems: List<OnBoardingItem>) :
    RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
        return OnBoardingViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_container_onboarding,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
        holder.bind(onBoardingItems[position])
    }

    override fun getItemCount(): Int {
        return onBoardingItems.size
    }

    inner class OnBoardingViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val textTitle = view.findViewById<TextView>(R.id.textTitle)
        private val textDescription = view.findViewById<TextView>(R.id.textDescription)
        private val textSwipe = view.findViewById<TextView>(R.id.textSwipe)
        private val imageIconCenter = view.findViewById<ImageView>(R.id.imageOnboardingIconCenter)
        private val imageIconLeft = view.findViewById<ImageView>(R.id.imageOnboardingIconLeft)
        private val imageIconRight = view.findViewById<ImageView>(R.id.imageOnboardingIconRight)

        fun bind(onBoardingItem: OnBoardingItem) {
            textTitle.text = onBoardingItem.title
            textDescription.text = onBoardingItem.description

            if (onBoardingItem.swipe != null) {
                textSwipe.visibility = TextView.VISIBLE
                textSwipe.text = onBoardingItem.swipe
            }

            if (onBoardingItem.icon != null) {
                imageIconCenter.visibility = ImageView.VISIBLE
                imageIconCenter.setImageResource(onBoardingItem.icon)
            }

            if (onBoardingItem.icon2 != null && onBoardingItem.icon3 != null) {
                imageIconLeft.visibility = ImageView.VISIBLE
                imageIconRight.visibility = ImageView.VISIBLE
                imageIconLeft.setImageResource(onBoardingItem.icon2)
                imageIconRight.setImageResource(onBoardingItem.icon3)
            }
        }
    }

}