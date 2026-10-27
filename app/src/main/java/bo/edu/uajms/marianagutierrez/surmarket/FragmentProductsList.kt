package bo.edu.uajms.marianagutierrez.surmarket

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bo.edu.uajms.marianagutierrez.surmarket.models.product

class FragmentProductsList : Fragment(){
    private lateinit var IMV_FRGProductsList_ShoppingCart: ImageView
    private lateinit var IMV_FRGProductsList_Search: ImageView
    private lateinit var ETX_FRGProductsList_Search: EditText
    private lateinit var BTN_FRGProductsList_AddProduct: Button
    private lateinit var RCV_FRGProductsList_ProductsList: RecyclerView

    private lateinit var adapterProducts: AdapterProducts

    private var listaProductos=mutableListOf<product>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews(view)
        configureListenners()
        configureRecyclerView()
        loadSampleProducts()
    }

    private fun initializeViews(view: View) {
       IMV_FRGProductsList_ShoppingCart=view.findViewById(R.id.IMV_FRGProductsList_ShoppingCart)
       IMV_FRGProductsList_Search=view.findViewById(R.id.IMV_FRGProductsList_Search)
       ETX_FRGProductsList_Search=view.findViewById(R.id.ETX_FRGProductsList_Search)
       BTN_FRGProductsList_AddProduct=view.findViewById(R.id.BTN_FRGProductsList_AddProduct)
       RCV_FRGProductsList_ProductsList=view.findViewById(R.id.RCV_FRGProductsList_ProductsList)
    }
    private fun configureListenners(){

    }
    private fun configureRecyclerView(){
        adapterProducts = AdapterProducts(
            productsList = listaProductos,
            clickOnBuy = { product ->
                Toast.makeText(requireContext(), getString(R.string.addCart) + "${product.name}", Toast.LENGTH_SHORT).show()
            }
        )
        RCV_FRGProductsList_ProductsList.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = adapterProducts
        }

    }
    private fun loadSampleProducts(){
        val productsSample = listOf(
            product(
                id = 1,
                name = "Camisa",
                category = "Ropa de Varón",
                price = 180.0,
                imageUrl = "",
                description = "Camisa de Varon Tommy Roja",
                availabel = true,
                stock = 1
            ),
            product(
                id = 2,
                name = "Pantalón",
                category = "Ropa de Varón",
                price = 210.0,
                imageUrl = "",
                description = "Pantalón de jean azul",
                availabel = true,
                stock = 1
            ),
            product(
                id = 3,
                name = "Polera",
                category = "Ropa de Varón",
                price = 160.0,
                imageUrl = "",
                description = "Polera polo Totto azul",
                availabel = true,
                stock = 1
            ),
            product(
                id = 4,
                name = "Zapatillas",
                category = "Ropa de Varón",
                price = 530.0,
                imageUrl = "",
                description = "Zapatillas Nike BLancas",
                availabel = true,
                stock = 1
            ),
            product(
                id = 5,
                name = "Zapatos",
                category = "Ropa de Varón",
                price = 330.0,
                imageUrl = "",
                description = "Zapatos negros Pegada",
                availabel = true,
                stock = 1
            )

            )
        listaProductos.clear()
        listaProductos.addAll(productsSample)
        adapterProducts.notifyChanged()

    }
}