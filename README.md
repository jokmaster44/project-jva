# Project JVA

Simple JavaFX application demonstrating form validation using a clean architecture approach.

## Overview

This project demonstrates:

- MVC-like structure (UI / Controller / Model)
- Generic validation interface (`Validator<T>`)
- Business validation logic separated from UI
- Unit testing with JUnit 5
- Clean and immutable data model

## 🏗 Project Structure
model → Data objects (JvaData)
├── validator → Validation logic
├── ui → JavaFX UI layer