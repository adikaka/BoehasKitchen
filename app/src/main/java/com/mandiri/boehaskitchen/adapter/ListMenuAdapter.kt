import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandiri.boehaskitchen.databinding.FragmentCategorymenuBinding
import com.mandiri.boehaskitchen.databinding.ItemCategoryMenuBinding
import com.mandiri.boehaskitchen.databinding.ItemMenuBinding
import com.mandiri.boehaskitchen.model.CategoryMenuModel
import com.mandiri.boehaskitchen.presentation.Meal

class ListMenuAdapter(
    private val listMenuData: MutableList<Meal>
) : RecyclerView.Adapter<ListMenuAdapter.ListMenuViewHolder>() {

    inner class ListMenuViewHolder(private val itemBinding: FragmentCategorymenuBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListMenuViewHolder {
        return ListMenuViewHolder(
            FragmentCategorymenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ListMenuAdapter.ListMenuViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}