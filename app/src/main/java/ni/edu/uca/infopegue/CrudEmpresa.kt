package ni.edu.uca.infopegue


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import ni.edu.uca.infopegue.dao.ShareObjectAdp
import ni.edu.uca.infopegue.databinding.FragmentCrudEmpresaBinding

class CrudEmpresa : Fragment() {
    private lateinit var binding: FragmentCrudEmpresaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCrudEmpresaBinding.inflate(layoutInflater)
        Guardar()
        Acciones()
        AccionClean()
        BorrarDatos()
        CargarDatos()
        return binding.root
    }

    private fun Guardar() {
        try {
            with(binding) {
                btnGuardar.setOnClickListener {
                    val nombreE = etNombre.text.toString()
                    val direccionE = etDireccion.text.toString()
                    val jefeE = etJefeEmpresa.text.toString()
                    val contactoE = etContacto.text.toString()
                    val correoE = etCorreoEmpresa.text.toString()
                    val descripcionE = etDescripEmpresa.text.toString()

                    if (nombreE == "" || direccionE == "" || jefeE == "" || contactoE == "" || correoE == "" || descripcionE == "") {
                        Toast.makeText(
                            context,
                            "Un campo esta vacio, y no se pudo guardar la Empresa",
                            Toast.LENGTH_LONG
                        ).show();
                    } else {
                        ShareObjectAdp.preferShared.saveNombre(nombreE)
                        ShareObjectAdp.preferShared.saveDireccion(direccionE)
                        ShareObjectAdp.preferShared.saveRepresentante(jefeE)
                        ShareObjectAdp.preferShared.saveContacto(contactoE)
                        ShareObjectAdp.preferShared.saveCorreoEm(correoE)
                        ShareObjectAdp.preferShared.saveDescripcionEm(descripcionE)
                        Toast.makeText(context, "Datos Guardados ", Toast.LENGTH_SHORT).show()
                        limpiar()
                    }
                }
            }

        } catch (ex: Exception) {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun AccionClean() {
        binding.btnLimpiar.setOnClickListener { limpiar() }
    }

    fun limpiar() {
        with(binding) {
            etNombre.setText("")
            etDireccion.setText("")
            etJefeEmpresa.setText("")
            etContacto.setText("")
            etCorreoEmpresa.setText("")
            etDescripEmpresa.setText("")


        }
        Toast.makeText(this.context, "Campos limpios", Toast.LENGTH_SHORT).show()
    }

    private fun BorrarDatos() {
        binding.btnEliminar.setOnClickListener {

            with(binding) {
                ShareObjectAdp.preferShared.RemoveNombreEm(etNombre.text.toString())
                ShareObjectAdp.preferShared.RemoveDireccion(etDireccion.text.toString())
                ShareObjectAdp.preferShared.RemoveRepresentante(etJefeEmpresa.text.toString())
                ShareObjectAdp.preferShared.RemoveContactoEm(etContacto.text.toString())
                ShareObjectAdp.preferShared.RemoveCorreoEm(etCorreoEmpresa.text.toString())
                ShareObjectAdp.preferShared.RemoveDescripcionEM(etDescripEmpresa.text.toString())
            }
            Toast.makeText(this.context, "Datos Borrados", Toast.LENGTH_SHORT).show()
            limpiar()

        }

    }

    private fun CargarDatos() {
        with(binding) {
            etNombre.setText(ShareObjectAdp.preferShared.getNombre())
            etDireccion.setText(ShareObjectAdp.preferShared.getDireccion())
            etJefeEmpresa.setText(ShareObjectAdp.preferShared.getRepresentante())
            etContacto.setText(ShareObjectAdp.preferShared.getContacto())
            etCorreoEmpresa.setText(ShareObjectAdp.preferShared.getCorreoEmp())
            etDescripEmpresa.setText(ShareObjectAdp.preferShared.getDescripcionEmp())
        }
    }

    private fun Acciones() {

        binding.IvPersona.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaDatosEmpresa)
        }
        binding.IvInicio.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaOfertasEmpresa)
        }
        binding.IvMail.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.PantallaRespuestasDeOfertas)
        }

    }
}



