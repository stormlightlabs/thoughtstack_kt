---
title: ThoughtStack Android ROADMAP
created: 2025-06-09
---

## MVP

### Setup

- Dependencies
    - Room for local decks & cards
    - Coil for photo loading
    - Google Play Billing Library (v7.1.1) for donations
- Configure signing & generate a release keystore (Play App Signing)

### Pre-made Decks & Storage

- Define JSON schema for card decks (e.g. "ACT," "CBT," "DBT", "Exercise")
- Load two mental-health decks from assets → Room on first launch.
- Implement Room DAOs & Entities for Deck and Card.

### Basic UI & Navigation

- Home screen
    - list of decks (pre-made + custom decks)
- Deck view
    - swipe-through cards; “Next” / “Back” buttons
- Card editor
    - dialog to _add custom cards_ (text + optional photo) into a new "Custom Deck"

### Monetization

- Consumable SKU(s) configured in Play Console (e.g. “Donate \$1,” “Donate \$5”).
- Implement BillingClient flow
    - Connect → query SKUs → launchPurchaseFlow → acknowledge ([support.google.com][3]).
- Simple **“Support us”** button

### Release

- Generate Android App Bundle (AAB) in Android Studio
- Fill listing
    - Title
    - short/long description
    - screenshots (use Compose previews)
- Upload to Internal Test → verify install → promote to Production

## v1

### v0.2

- Polish UI
    - deck thumbnails
    - card styling
    - Persist custom decks across devices with Firebase Sync

### v0.3

- Export/Import decks via JSON
- Add deck-sharing (deep links)

### v0.4

- Timer module
    - implement a simple countdown UI like Time Timer

### v0.5

- HIIT/Tabata timers
    - presets
    - configurable intervals
    - audio cues
    - background service

### v1.0

- Refine UX: onboarding, analytics, dark mode.<br>• Beta feedback round & bug-fixing.<br>•
  Marketing: launch blog post + social.

[1]: https://developer.android.com/google/play/billing/integrate?utm_source=chatgpt.com "Integrate the Google Play Billing Library into your app"

[2]: https://developer.android.com/studio/publish/upload-bundle?utm_source=chatgpt.com "Upload your app to the Play Console | Android Studio"

[3]: https://support.google.com/googleplay/android-developer/answer/10281818?hl=en&utm_source=chatgpt.com "Understanding Google Play's Payments policy - Play Console Help"

[4]: https://developer.android.com/guide/app-bundle/test?utm_source=chatgpt.com "Build and test your Android App Bundle | Google Play"

[5]: https://developer.android.com/guide/playcore/engage/healthandfitness?utm_source=chatgpt.com "Engage SDK Health and Fitness: Third-party technical integration ..."
