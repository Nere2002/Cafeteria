// AuthViewModel.kt
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.skye.cafeteria.User

class AuthViewModel : ViewModel() {
    // LiveData obserbable resulatado autenticacion
    val authResult = MutableLiveData<Boolean>()

    // lista usuarios
    private val userList = mutableListOf<User>()

    init {
        // usuarios predeterminados
        userList.add(User("admin", "admin123"))
        userList.add(User("nere", "1234"))
        userList.add(User("user2", "password2"))
    }

    fun loginUser(username: String, password: String) {
        // mirar si usuario i contraseña son forrectas
        val userToAuthenticate = User(username, password)
        val isSuccess = userList.contains(userToAuthenticate)
        authResult.value = isSuccess
    }

    fun registerUser(username: String, password: String) {
        // Verificar si el nombre de usuario ya está en uso
        val isNewUser = userList.none { it.username == username }

        if (isNewUser) {
            // Registrar al nuevo usuario
            val newUser = User(username, password)
            addUser(newUser)
            authResult.value = true

        } else {
            authResult.value = false

        }
    }

    private fun addUser(user: User) {
        userList.add(user)
    }


}
