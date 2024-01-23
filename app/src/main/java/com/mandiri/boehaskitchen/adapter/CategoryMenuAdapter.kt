import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.boehaskitchen.databinding.ItemCategoryMenuBinding
import com.mandiri.boehaskitchen.model.CategoryMenuModel

class CategoryMenuAdapter(
    private val categoryMenuData: MutableList<CategoryMenuModel>
): RecyclerView.Adapter<CategoryMenuAdapter.CategoryMenuViewHolder>() {

    private  var _onClickCategoryMenu: (CategoryMenuModel) -> Unit ={}

    inner class CategoryMenuViewHolder(private val itemBinding: ItemCategoryMenuBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(data: CategoryMenuModel, listener: (CategoryMenuModel) -> Unit){
            itemBinding.tvTitleMenu.text = data.name
            itemBinding.tvRating.text = data.rating
            itemBinding.tvPrice.text = data.price
            itemBinding.tvRespon.text = data.respon
            itemBinding.imgCategoryMenu.setImageResource(data.imageCard)
            itemBinding.root.setOnClickListener{
                listener.invoke(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryMenuViewHolder {
        return CategoryMenuViewHolder(
            ItemCategoryMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = categoryMenuData.size

    override fun onBindViewHolder(holder: CategoryMenuViewHolder, position: Int) {
        holder.bind(categoryMenuData[position], _onClickCategoryMenu)
    }

    fun setOnClickCategoriModel(listener: (CategoryMenuModel) -> Unit){
        _onClickCategoryMenu = listener
    }

}