# Expense Tracker

A modern, privacy-first Android expense management application enhanced with **local AI-powered spending insights**.

This project extends an existing open-source Expense Manager application by adding a local AI analysis feature powered by **Ollama** and the open-weight **Gemma 3 4B** model. The application analyzes the selected month's financial data locally and generates natural-language spending insights.

> **Privacy First:** Your financial data remains on your device/local network. The AI analysis is performed using a locally hosted Ollama model rather than a cloud AI API.

---

## ✨ Features

### 💰 Expense & Income Management

- Add and manage income and expenses.
- Track transfers between accounts.
- Organize transactions using categories.
- View transaction history.
- Monitor monthly budgets.

### 📊 Financial Analysis

- Daily, weekly, and monthly spending statistics.
- Category-wise expense analysis.
- Budget versus actual spending.
- Visual charts and aggregated financial data.
- Monthly income, expenses, and savings overview.

### 🤖 Local AI Spending Insights

The main addition to this project is the **AI Spending Insights** feature.

- Generates financial insights for the **currently selected month**.
- Identifies high-spending and over-budget categories.
- Explains spending patterns in natural language.
- Provides suggestions based on the supplied financial summary.
- Uses **Ollama** to run an LLM locally.
- Uses the open-weight **Gemma 3 4B** model.
- Financial totals are calculated by the application before being sent to the LLM.
- The LLM is used primarily for explanation and interpretation rather than performing critical financial calculations.
- Uses a smaller 4B parameter model to keep local inference relatively lightweight and responsive.

### ⚡ Lightweight Local AI

Gemma 3 4B is smaller than the previously used Qwen 7B model.

This makes it a practical choice for local inference because it generally:

- Requires fewer computational resources.
- Uses less memory than larger language models.
- Can provide faster responses on suitable local hardware.
- Is better suited for running AI features on a personal computer without relying on a cloud AI API.

> Actual inference speed depends on the computer's CPU/GPU, available RAM, Ollama configuration, prompt size, and system load.

### 🔒 Privacy

- Financial transactions are stored locally using **Room Database**.
- No cloud database is required.
- No financial information is sent to a third-party AI API.
- AI processing uses a locally hosted Ollama instance.
- No tracking or cloud synchronization is required for the core application.

### 🎨 Modern Android UI

- Jetpack Compose
- Material 3
- Dark Mode
- Reactive UI
- MVVM architecture

---

# 🧠 How the Local AI Works

The AI feature follows this flow:

```text
User selects a month
        ↓
Android application retrieves transactions
        ↓
Local Kotlin logic calculates:
        • Income
        • Expenses
        • Savings
        • Category totals
        • Budget vs actual
        ↓
Structured monthly summary
        ↓
Ollama Local API
        ↓
Gemma 3 4B
        ↓
Natural-language spending explanation
        ↓
Displayed in the Analysis screen
```

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| **Kotlin** | Application development |
| **Jetpack Compose** | UI |
| **Material 3** | UI design |
| **MVVM** | Application architecture |
| **Clean Architecture** | Project structure |
| **Koin** | Dependency Injection |
| **Room** | Local database |
| **Kotlin Coroutines & Flow** | Reactive data handling |
| **OkHttp** | Communication with Ollama |
| **Ollama** | Local LLM runtime |
| **Gemma 3 4B** | Local open-weight language model |
| **Gradle Kotlin DSL** | Build system |


## 📁 Project Structure

```text
Expense-Trackers/
│
├── app/                         # Main Android application
│
├── core/
│   ├── common/                  # Common utilities
│   ├── database/                # Room database
│   ├── designsystem/            # Compose design system
│   ├── model/                   # Data models
│   └── repository/              # Repository implementations
│
├── feature/                     # Application features/screens
│
├── build-logic/                 # Gradle convention plugins
│
├── gradle/                      # Gradle configuration
│
├── docs/                        # Project documentation
│
├── README.md
├── LICENSE
├── build.gradle.kts
└── settings.gradle.kts
```

🚀 Getting Started
Prerequisites
Before running the application, install:
1. Android Studio
2. JDK 17 or higher compatible with the project
3. Android SDK
4. Ollama
   Use the JDK version configured by the project's Gradle and Android Gradle Plugin setup if Android Studio reports a specific requirement.

```1. Clone the Repository
   git clone https://github.com/chetanbhandari01/Expense-Trackers.git
   cd Expense-Trackers
```
Open the project in Android Studio.
Allow Android Studio to:
- Sync Gradle
- Download dependencies
- Install any required Android SDK components
```2. Install Ollama
   Download Ollama from:
   https://ollama.com/
   After installation, verify that Ollama is available:
   ollama --version
```
```3. Download the Gemma 3 4B Model
   Run:
   ollama pull gemma3:4b
```
```Verify that the model is installed:
ollama list

You should see:
gemma3:4b
```
You can also test the model directly:
ollama run gemma3:4b

4. Configure Ollama for Android
   Android Emulator
   When using the Android Emulator, the host computer can generally be accessed through:
   http://10.0.2.2:11434

The project is configured to use this emulator-to-host route for local Ollama communication.
Physical Android Device
If you are running the application on a physical Android phone:
1. Connect the phone and computer to the same Wi-Fi network.
2. Find your computer's local IPv4 address.
3. Configure Ollama to accept connections from the local network.
4. Update the Ollama base URL in the application if necessary.
   For example:
   http://YOUR_COMPUTER_IP:11434

Note: Do not use 10.0.2.2 for a physical Android device.

```5. Run the Application
   From the project directory:
   ./gradlew assembleDebug
```
```
On Windows PowerShell:
.\gradlew.bat assembleDebug
```
Or open the project in Android Studio and click:
Run ▶
🧪 Testing the AI Feature
After launching the application:
1. Add some income and expense transactions.
2. Navigate to the Analysis screen.
3. Select a month containing transactions.
4. Click Analyze My Spending.
5. The application calculates the selected month's financial summary.
6. The summary is sent to the local Ollama server.
7. Gemma 3 4B generates a natural-language explanation.
8. The result is displayed in the application.
   Month-Specific Analysis
   Try changing the selected month and generating the analysis again.
   The AI context should correspond to the currently selected month.

🔐 Privacy & Security
````
   Your financial data
   │
   ▼
   Local Android Database
   │
   ▼
   Monthly aggregation
   │
   ▼
   Local Ollama server
   │
   ▼
   Gemma 3 4B
   │
   ▼
   AI explanation

There is no requirement for an OpenAI, Gemini, or other cloud LLM API key.

🤝 Contributions
Contributions and suggestions are welcome.
If you find a bug or have an idea for improving the AI spending analysis:
1. Open an issue.
2. Describe the problem or feature.
3. Provide relevant reproduction steps where possible.
4. Submit a pull request for improvements.
