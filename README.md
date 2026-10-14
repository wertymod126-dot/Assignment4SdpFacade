# Döner Kebab Fast-Food Management System — Facade Pattern

## Overview
This repository contains an implementation of the **Facade Structural Design Pattern** in Java for a Döner Kebab kitchen workflow.

## Pattern Components
- **Facade:** `DonerShopFacade` — Coordinates the entire ordering process through a single `placeDonerOrder()` method.
- **Subsystem Classes (5):**
  1. `IngredientInventory` — Manages meat and lavash stock validation and reservation.
  2. `OrderCustomizer` — Calculates total pricing and builds custom recipe notes.
  3. `PaymentProcessor` — Validates and executes customer payments.
  4. `KitchenGrillQueue` — Enqueues order tickets and handles grilling status.
  5. `PackagingAndDispatch` — Packages orders (takeout vs. dine-in) and sends customer pickup alerts.
- **Client:** `Main.java` — Demonstrates standard client usage via the Facade, as well as direct subsystem access by advanced clients (Head Chef console).

## Clean Code Principles Applied
1. **Single Responsibility Principle (SRP):** `DonerShopFacade` is strictly responsible for workflow orchestration, delegating actual business logic (inventory, payments, cooking) to separate subsystem classes.
2. **Meaningful Names:** High-level method names like `placeDonerOrder()` clearly express client intent without exposing internal subsystem mechanics.
3. **No Leaking of Subsystem Details:** The Facade accepts standard Java parameters (`String`, `List`, `boolean`, `double`) rather than forcing the client to handle internal subsystem classes directly.
4. **Small, Focused Subsystem Classes:** Each subsystem class handles a single domain responsibility (e.g., `PaymentProcessor` handles money, `IngredientInventory` handles stock).
5. **Proper Error Handling:** The Facade validates stock availability and payment amounts prior to sending tickets to the kitchen, aborting gracefully with clear error messages if validation fails.
