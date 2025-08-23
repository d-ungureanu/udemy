package tips.my2cents.myrecipeapp

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.State
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _categoriesState = mutableStateOf(RecipeState())
    val categoriesState: State<RecipeState> = _categoriesState

    init {
        fetchCategories()
    }

    private fun fetchCategories() {
        viewModelScope.launch {
            try {
                val response = recipeService.getCategories()
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false,
                    list = response.categories,
                    error = null
                )
            } catch (error: Exception) {
                _categoriesState.value = _categoriesState.value.copy(
                    isLoading = false,
                    error = "Error while fetching categories: ${error.localizedMessage}"
                )

            }
        }
    }


    data class RecipeState(
        val isLoading: Boolean = true,
        val list: List<Category> = emptyList(),
        val error: String? = null
    )
}