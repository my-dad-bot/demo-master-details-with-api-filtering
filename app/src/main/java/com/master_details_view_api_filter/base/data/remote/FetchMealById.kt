package com.master_details_view_api_filter.base.data.remote
import com.google.gson.annotations.SerializedName


data class FetchMealById(
    @SerializedName("meals")
    val meals: List<Meal>
)

data class Meal(
    @SerializedName("dateModified")
    val dateModified: Any, // null
    @SerializedName("idMeal")
    val idMeal: String, // 52993
    @SerializedName("strArea")
    val strArea: String, // American
    @SerializedName("strCategory")
    val strCategory: String, // Chicken
    @SerializedName("strCreativeCommonsConfirmed")
    val strCreativeCommonsConfirmed: Any, // null
    @SerializedName("strDrinkAlternate")
    val strDrinkAlternate: Any, // null
    @SerializedName("strImageSource")
    val strImageSource: Any, // null
    @SerializedName("strIngredient1")
    val strIngredient1: String, // Potatoes
    @SerializedName("strIngredient10")
    val strIngredient10: String, // Olive Oil
    @SerializedName("strIngredient11")
    val strIngredient11: String,
    @SerializedName("strIngredient12")
    val strIngredient12: String,
    @SerializedName("strIngredient13")
    val strIngredient13: String,
    @SerializedName("strIngredient14")
    val strIngredient14: String,
    @SerializedName("strIngredient15")
    val strIngredient15: String,
    @SerializedName("strIngredient16")
    val strIngredient16: String,
    @SerializedName("strIngredient17")
    val strIngredient17: String,
    @SerializedName("strIngredient18")
    val strIngredient18: String,
    @SerializedName("strIngredient19")
    val strIngredient19: String,
    @SerializedName("strIngredient2")
    val strIngredient2: String, // Broccoli
    @SerializedName("strIngredient20")
    val strIngredient20: String,
    @SerializedName("strIngredient3")
    val strIngredient3: String, // Garlic
    @SerializedName("strIngredient4")
    val strIngredient4: String, // Chicken Breast
    @SerializedName("strIngredient5")
    val strIngredient5: String, // Balsamic Vinegar
    @SerializedName("strIngredient6")
    val strIngredient6: String, // Honey
    @SerializedName("strIngredient7")
    val strIngredient7: String, // Chicken Stock
    @SerializedName("strIngredient8")
    val strIngredient8: String, // Butter
    @SerializedName("strIngredient9")
    val strIngredient9: String, // Vegetable Oil
    @SerializedName("strInstructions")
    val strInstructions: String, // 2 Servings1. Preheat oven to 425 degrees. Wash and dry all produce. Cut potatoes into 1/2-inch-thick wedges. Toss on one side of a baking sheet with a drizzle of oil, salt, and pepper. (For 4 servings, spread potatoes out across entire sheet.) Roast on top rack for 5 minutes (we'll add the broccoli then). 2. Meanwhile, cut broccoli florets into bite-size pieces, if necessary. Peel and finely chop garlic. In a small microwave-safe bowl, combine 1 TBSP olive oil (2 TBSP for 4 servings) and half the garlic. Microwave until garlic sizzles, 30 seconds. 3. Once potatoes have roasted 5 minutes, remove sheet from oven and add broccoli to empty side; carefully toss with garlic oil, salt, and pepper. (For 4 servings, add broccoli to a second sheet.) Continue roasting until potatoes and broccoli are browned and crispy, 15-20 minutes more. 4. While veggies roast, pat chicken dry with paper towels; season all over with salt and pepper. Heat a drizzle of oil in a large pan over medium-high heat. Add chicken and cook until browned and cooked through, 5-6 minutes per side. (If chicken browns too quickly, reduce heat to medium.) Turn off heat; set chicken aside to rest. Wash out pan. 5. Heat pan used for chicken over medium-high heat. Add a drizzle of oil and remaining garlic; cook until fragrant, 30 seconds. Stir in vinegar, honey, stock concentrate, and 1/4 cup water (1/3 cup for 4 servings). Simmer until thick and glossy, 2-3 minutes. Remove from heat and stir in 1 TBSP butter (2 TBSP for 4). Season with salt and pepper. 6. Return chicken to pan and turn to coat in glaze. Divide chicken, broccoli, and potatoes between plates. Spoon any remaining glaze over chicken and serve.
    @SerializedName("strMeal")
    val strMeal: String, // Honey Balsamic Chicken with Crispy Broccoli & Potatoes
    @SerializedName("strMealThumb")
    val strMealThumb: String, // https://www.themealdb.com/images/media/meals/kvbotn1581012881.jpg
    @SerializedName("strMeasure1")
    val strMeasure1: String, // 5
    @SerializedName("strMeasure10")
    val strMeasure10: String, // 1 tbsp
    @SerializedName("strMeasure11")
    val strMeasure11: String,
    @SerializedName("strMeasure12")
    val strMeasure12: String,
    @SerializedName("strMeasure13")
    val strMeasure13: String,
    @SerializedName("strMeasure14")
    val strMeasure14: String,
    @SerializedName("strMeasure15")
    val strMeasure15: String,
    @SerializedName("strMeasure16")
    val strMeasure16: String,
    @SerializedName("strMeasure17")
    val strMeasure17: String,
    @SerializedName("strMeasure18")
    val strMeasure18: String,
    @SerializedName("strMeasure19")
    val strMeasure19: String,
    @SerializedName("strMeasure2")
    val strMeasure2: String, // 1
    @SerializedName("strMeasure20")
    val strMeasure20: String,
    @SerializedName("strMeasure3")
    val strMeasure3: String, // 2 cloves
    @SerializedName("strMeasure4")
    val strMeasure4: String, // 2
    @SerializedName("strMeasure5")
    val strMeasure5: String,
    @SerializedName("strMeasure6")
    val strMeasure6: String,
    @SerializedName("strMeasure7")
    val strMeasure7: String,
    @SerializedName("strMeasure8")
    val strMeasure8: String, // 1 tbsp
    @SerializedName("strMeasure9")
    val strMeasure9: String, // 1 tbsp
    @SerializedName("strSource")
    val strSource: String,
    @SerializedName("strTags")
    val strTags: Any, // null
    @SerializedName("strYoutube")
    val strYoutube: String
)