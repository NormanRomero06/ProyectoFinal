package ni.edu.uca.infopegue

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentOfertasClienteBinding
import ni.edu.uca.infopegue.entidades.Oferta
import ni.edu.uca.infopegue.rv_adapter.ofertaAdapter

class OfertasCliente : Fragment(){
    private lateinit var binding: FragmentOfertasClienteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentOfertasClienteBinding.inflate(layoutInflater)
        iniciar()
        Acciones()
        return binding.root



    }

    private fun iniciar() {
        var arreglo = ShareObjectAdp.preferShared.getArray()
        var list = arrayListOf<Oferta>()

        for(Keys in arreglo.keys){
            if (!Keys.equals("A")){
                var oferta: Oferta = arreglo[Keys]!!
                oferta.key = Keys
                list.add(oferta)
            }
        }
        with(binding.rcvPropuesta){
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = ofertaAdapter(list,binding.root)
        }

    }

    private fun Acciones() {

        binding.IvPersona.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaDatosCliente)
        }
        binding.IvInicio.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasCliente)
        }
        binding.IvMail.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaRespuestasDeOfertas)
        }
    }



}