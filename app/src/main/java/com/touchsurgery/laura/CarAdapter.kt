package com.touchsurgery.laura

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/** Create the interface for the user events */
interface RecyclerViewEvent {
    fun onItemClick(position: Int)
}


class CarAdapter(
    private val cars: MutableList<Car>,
    private val listener: RecyclerViewEvent /** the activity will implement this interface and pass an instance of it to our adapter class */
) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    /** add View.OnClickListener */
    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        /** attach the onclick listener, this = View.OnClickListener
        * every time an item in the recycler view list(row) is clicked the onClick method will be called */
        init { itemView.setOnClickListener(this) }

        override fun onClick(v: View?) {
            /** extract current adapter position, check that the position is valid and pass the position extracted from the adapter to the listener */
            val position = absoluteAdapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val currentCar = cars[position]

        holder.itemView.apply {
            findViewById<TextView>(R.id.textView_carMake).text = currentCar.make
            findViewById<TextView>(R.id.textView_carModel).text = currentCar.model
            findViewById<TextView>(R.id.textView_carYear).text =
                currentCar.year.toString() /** write Int value into the text view from the year Int */
        }
    }
}