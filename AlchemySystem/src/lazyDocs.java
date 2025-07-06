public class lazyDocs {

//     🔬 Alchemy System Assignment Overview
// 1. Base Concept
// Design a system where ingredients can be combined to craft potions with specific effects.
// Each ingredient has properties, and different combinations produce different potions.

// 📌 Assignment Components
// 1. Ingredient Hierarchy
// Create an abstract class Ingredient.

// Extend it with specific types: Herb, Mineral, Essence.

// Each subclass should have a describe() method and possibly a getEffect().

// 🧠 Goal: Practice inheritance and polymorphism.

// 2. Potion Class
// Create a Potion class with attributes like name, effect, and value.

// Potions are created from multiple ingredients.

// 🧠 Goal: Understand aggregation (a potion is composed of ingredients).

// 3. Recipe System
// Each potion recipe requires specific ingredient types or combinations.

// Store these recipes in a Map<String, Recipe>, where the key is the potion name.

// A Recipe object should know its required ingredients.

// 🧠 Goal: Learn to use Map and design custom data structures.

// 4. Crafting Logic
// Write a method to take a list of ingredients and try to match them to a recipe.

// If matched, create and return a Potion object.

// 🧠 Goal: Practice comparison logic and control flow.

// 5. Inventory of Ingredients
// Store owned ingredients in an ArrayList or Map.

// Let the user add or remove ingredients.

// Display current inventory contents.

// 🧠 Goal: Practice collection manipulation.

// 6. User Interaction
// Build a text-based menu for:

// Viewing ingredients

// Viewing available recipes

// Attempting to craft a potion

// Viewing crafted potions

// 🧠 Goal: Practice input handling and program structure.

// 7. Stretch Goals (Optional)
// Allow combining ingredients in any order.

// Add a rarity or power level to ingredients.

// Save/load potion history or inventory to a file.

// 🧠 Goal: Challenge yourself beyond the base requirements.


}
