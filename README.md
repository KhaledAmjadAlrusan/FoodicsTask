# Foodics Task
This project is an Android application designed to showcase modern architecture, efficient data management, and a seamless user experience. It follows a Clean Architecture approach with MVVM pattern and modularity principles. Implemented with Jetpack Compose for UI, it integrates mock APIs for dynamic data handling and local caching.

## 📐✏️ Architecture
The app is structured using a **Clean Module UseCase** architecture, adhering to the **MVVM pattern** for maintainability and scalability. It is divided into the following modules:

- **App**: Orchestrates navigation and app-level configurations.
- **Core**: Centralized utilities, constants, and shared resources.
- **Domain**: Defines business logic and UseCases, ensuring clean interaction between layers.
- **Data**: Handles API interactions via KTOR and local data persistence with Room.
- **Presentation**: Manages user interfaces and interactions through Jetpack Compose.

### Workflow
1. **Search Products**:
   - Users type product names in the search bar.
   - ViewModel filters and returns relevant results via UseCases.
   - Filtered products are displayed dynamically in the UI.

2. **Order Management**:
   - Users add products to orders directly from the product list.
   - View displays the total price and product quantities.
   - "View Order" resets the order, readying the app for a new session.

3. **Data Flow**:
   - Data fetched through KTOR APIs is cached locally using Room.
   - Offline-first approach ensures reliable user experience.

4. **UI Components**:
   - **Tables Screen**: Displays categorized products and details.
   - **Orders Screen**: Placeholder for future expansion.
   - **Menu Screen**: Placeholder for upcoming features.
   - **Settings Screen**: Placeholder for configuration options.

### Navigation
A bottom navigation bar simplifies access to primary screens, including "Orders," "Menu," and "Settings."

### Responsiveness
The app is designed for **portrait mode** and optimized for various screen sizes, ensuring adaptability and visual consistency.

## 🛠 Tech Stack
- **[Kotlin](https://developer.android.com/kotlin)**: Modern, expressive programming language for Android development.
- **Jetpack Compose**: Simplified, declarative UI toolkit.
- **Material 3**: Contemporary design components.
- **KTOR**: Lightweight and efficient for API communications.
- **KOIN**: Dependency injection with minimal boilerplate.
- **Room**: Robust local data storage solution.
- **MVVM**: Architectural patterns for scalable app development.
- **Coil**: Image loading library optimized with Kotlin Coroutines.

### Supporting Libraries
- **Kotlin Coroutines**: Simplifies asynchronous programming.
- **Flow**: Reactive streams for handling data.
- **Mockaroo**: Mock APIs for testing and prototyping.

## 🚀 Key Features
### 1. Dynamic Product Search
- Filters products in real-time as users type in the search bar.

### 2. Intuitive Order Management
- Add products directly to orders with a single tap.
- Real-time updates for total price and quantity.
- Reset order data with "View Order" for a seamless workflow.

### 3. Robust Data Handling
- Fetch and cache product data via mock APIs and Room.
- Reliable offline experience with cached data.

### 4. Modern UI Design
- Responsive, portrait-mode interface.
- Adaptable layouts for various screen sizes and resolutions.

## 🗺️ Screens and Navigation
- **Tables Screen**: Lists categories and detailed product information.
- **Orders Screen**: Placeholder for advanced order management.
- **Menu Screen**: Placeholder for menu functionalities.
- **Settings Screen**: Placeholder for user preferences.

## 📦 Modular Breakdown
1. **App**: Coordinates navigation and lifecycle.
2. **Core**: Hosts reusable utilities and components.
3. **Domain**: Governs business logic and UseCases.
4. **Data**: Handles network and local storage operations.
5. **Presentation**: Composes the UI and manages state.

## 💡 Future Enhancements
- Implement a "Cart" screen for detailed order tracking.
- Extend offline capabilities with enhanced caching mechanisms.
- Add rich features to "Orders" and "Settings" screens for better user customization.