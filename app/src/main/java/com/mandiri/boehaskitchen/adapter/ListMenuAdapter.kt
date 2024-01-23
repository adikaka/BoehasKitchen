import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mandiri.boehaskitchen.R
import com.mandiri.boehaskitchen.databinding.FragmentCategorymenuBinding
import com.mandiri.boehaskitchen.databinding.ItemCategoryMenuBinding
import com.mandiri.boehaskitchen.databinding.ItemMenuBinding
import com.mandiri.boehaskitchen.model.CategoryMenuModel
import com.mandiri.boehaskitchen.presentation.Meal

class ListMenuAdapter(
    private var listMenuData: MutableList<Meal>
) : RecyclerView.Adapter<ListMenuAdapter.ListMenuViewHolder>() {

    private  lateinit var contextMenu : Context
    inner class ListMenuViewHolder( val itemBinding: ItemMenuBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMenuViewHolder {
        contextMenu = parent.context
        return ListMenuViewHolder(
            ItemMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListMenuAdapter.ListMenuViewHolder, position: Int) {
        holder.itemBinding.tvTitleMenu.text = listMenuData[position].strMeal
        Glide.with(contextMenu).load(listMenuData[position].strMealThumb).placeholder(R.drawable.img_maindiches).into(holder.itemBinding.ivFoodImg)

        holder.itemBinding.root.setOnClickListener{
            val mealId = listMenuData[position].idMeal
            _onClickCategoryDetailMenu.invoke(mealId)
        }
    }

    override fun getItemCount(): Int {
        return listMenuData.size
    }

    fun setDataMenu(data : MutableList<Meal>){
        listMenuData = data
        notifyDataSetChanged()
    }

    lateinit var _onClickCategoryDetailMenu : (String) -> Unit
    fun setOnClickDetailMenuModel(listener: (String) -> Unit){
        _onClickCategoryDetailMenu = listener
    }
}