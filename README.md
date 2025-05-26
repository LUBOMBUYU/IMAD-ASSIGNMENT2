# 🏛️ History Flash

**History Flash** is an interactive native Android quiz app built with **Kotlin** in **Android Studio**. It helps users reinforce their history knowledge through a fun, engaging flashcard system. Users answer true/false questions, receive immediate feedback, and get a final score and review screen.

---

## 📸 Screenshots

### 1. Start Menu
- Displays the vibrant **History Flash** logo.
- Contains a **Start Quiz** button and info icon.

![Start Menu](https://github.com/user-attachments/assets/0c00d2a3-3db3-491a-aca0-d47b5efa59d6)

---

### 2. Flashcard Question Screen
- Shows a question in a central panel.
- **True** and **False** buttons for user input.
- **Next** button and a sound toggle icon.
- Background features classical decorative imagery.
- A **countdown timer** is added challenge.

![Flashcard Screen](https://github.com/user-attachments/assets/0135c075-d702-46a1-ac80-e2bffbf44799)

---

### 3. Score Screen
- Displays:
  - Final Score (e.g., `Score: 5/5`)
  - Percentage (e.g., `Percentage: 100%`)
  - Feedback (e.g., “Great job!” or “Keep practicing!”)
- **Retake Quiz** and **Exit** buttons.

![Score Screen](https://github.com/user-attachments/assets/b05b7532-2fb5-4f0a-a4af-4c7207eb0232)

---

## 🧠 Features

- ✅ True/False flashcard quiz format
- ✅ Live feedback after each question
- ✅ Final score and feedback message
- ✅ Review screen with correct answers
- ✅ Vibrant themed UI (history/classical)
- ✅ Sound toggle (mute/unmute)
- ✅  Countdown timer per question

---

## ⏳ Addtional Features

### Countdown Timer
Once the user presses the **Start** button, a countdown will begin to prepare the user for the first flashcard. This feature will enhance the user experience by adding time-based pressure.

![Timer Mockup](https://github.com/user-attachments/assets/06051736-865b-4165-ab07-b5522ac1d01c)

---

## 📁 GitHub Repository

🔗 [https://github.com/LUBOMBUYU/IMAD_ASSIGNMENT2](https://github.com/LUBOMBUYU/IMAD-ASSIGNMENT2.git)



---

## 🎥 Video Demonstration

📺 [Click here to watch the full demo on YouTube](https://youtu.be/ktm1-UCHcW8)

The video walks through:
- Starting the app
- Answering questions
- Navigating between screens
- Reviewing final results


---

## 🛠️ Tech Stack

- **Kotlin**
- **Android Studio**
- **GitHub** for version control
- **GitHub Actions** for automated builds and testing

---
## 🖥️ GitHub Actions – Automatic Builds
**History Flash** uses **GitHub Actions** to automatically build the app when you push code to the main branch or run it manually. This helps keep everything up to date and makes it easy to download the APK or AAB file without building it yourself.

## ⚙️ What the Workflow Does
The GitHub Actions workflow (build.yml) does the following steps:

**Starts when:**

You push code to the main branch

You manually run it from the GitHub Actions tab

**Sets up the environment:**

Uses Java 17 (needed to build Android apps)

Sets the current date and repository name for naming the files

**Build steps:**

Cleans the previous builds

Runs unit tests to check if the code works correctly

**Builds:**

Debug APK (for testing)

Release APK (for production)

AAB (used for Play Store)

**Uploads the results:**

You can download the APK or AAB files directly from GitHub

Each file is named with the date, app name, and type (debug/release)

Example file name:
📦 2025-05-26 - Frogobox ID - IMAD-ASSIGNMENT2 - APK(s) release generated

✅ Why This Is Useful
🔁 No need to build the app yourself — GitHub does it for you

🧪 Runs tests to check if the app works correctly

📦 Easily download ready-made APK and AAB files

🛠️ Great for testing and sharing with others

## 📚 Report Summary

- **Purpose:** To create a history-learning app using a flashcard quiz system.
- **Design Considerations:** The UI is built for simplicity, engagement, and visual appeal using historical/classical themes.
- **GitHub Utilization:** The code is pushed and version-controlled via GitHub. Commits are descriptive and meaningful.
- **GitHub Actions:** Implemented to automate builds and testing across machines using the provided `build.yml` workflow.

---


