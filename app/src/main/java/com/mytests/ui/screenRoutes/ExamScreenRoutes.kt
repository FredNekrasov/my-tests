package com.mytests.ui.screenRoutes

sealed class ExamScreenRoutes(val route: String) {
    data object DataList : ExamScreenRoutes("DataListRoute")
    data object Authorization : ExamScreenRoutes("AuthorizationRoute")
    data object Registration : ExamScreenRoutes("RegistrationRoute")
    data object Profile : ExamScreenRoutes("ProfileRoute")
    data object Favorites : ExamScreenRoutes("FavoritesRoute")
}