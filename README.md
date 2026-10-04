# AI Expense Manager

A modern, privacy-first Android application designed to help you track your daily income and expenses, complete with **Local AI Spending Insights**.

This app securely analyzes your spending habits and provides natural-language financial summaries using an open-weight Large Language Model (LLM) via Ollama—meaning **none of your financial data ever leaves your local network**.

*This project is an extended fork of the original open-source [Expense Manager](https://github.com/nkuppan/expense-manager) by Naveen Kumar Kuppan.*

---

## 📱 Features

### Core Functionality
*   **Comprehensive Tracking**: Log income, expenses, and transfers easily.
*   **Budgets & Categories**: Set monthly budgets and categorize transactions to monitor spending limits.
*   **Data Visualization**: View beautiful charts, graphs, and aggregated stats (daily, weekly, monthly).
*   **Privacy First**: All data is stored locally using Room Database. No cloud sync, no tracking.
*   **Modern UI**: Built entirely with Jetpack Compose, featuring Material 3 Design and Dark Mode support.

### 🤖 AI Spending Insights (New)
*   **Local AI Analysis**: Generates month-specific financial insights (e.g., highlighting over-budget categories or unusual spending).
*   **Ollama Integration**: Uses a locally hosted `qwen:7b` model over your network via OkHttp.
*   **Reactive Context**: The AI automatically adjusts its analysis based on the specific month you are viewing on the dashboard.

---

## 🛠 Tech Stack

*   **Language**: Kotlin
*   **UI Toolkit**: Jetpack Compose
*   **Architecture**: Clean Architecture + MVVM (Model-View-ViewModel)
*   **Dependency Injection**: Koin
*   **Database**: Room Database
*   **Networking**: OkHttp (for local LLM communication)
*   **Build System**: Gradle with Kotlin DSL and Version Catalogs (`libs.versions.toml`)

---

## 🚀 How to Start the Application

### Prerequisites
1.  **Android Studio**: Ladybug (or the latest stable version).
2.  **JDK 19**: Ensure your Gradle JDK is set to Java 19 or higher.
3.  **Ollama**: Installed and running on your local machine.

### Step 1: Set up the Local AI (Ollama)
1. Download and install [Ollama](https://ollama.com/).
2. Open your computer's terminal/command prompt and download the required model:
   ```bash
   ollama run qwen:7b
   ```
3. Keep Ollama running in the background. It defaults to listening on port `11434`.

### Step 2: Configure the App
By default, the app is configured to look for the Ollama server on your host machine.
If you are running the app on the **Android Emulator**, the app uses your local network IP (e.g., `http://10.186.159.1:11434` or `http://10.0.2.2:11434`).
*   *Note: If you want to run this on a physical device, ensure both your phone and computer are on the same Wi-Fi, and update the `baseUrl` in `OllamaRepository.kt` to match your computer's IPv4 address.*

### Step 3: Build & Run
1. Clone this repository:
   ```bash
   git clone <your-repository-url>
   ```
2. Open the project in **Android Studio**.
3. Allow Gradle to sync and download dependencies.
4. Click the **Run 'app'** button (Play icon) in Android Studio, or build via command line:
   ```bash
   ./gradlew assembleDebug
   ```
5. Once the app launches, add some transactions, navigate to the **Analysis** tab, and click **"Analyze My Spending"** to test the local AI!

