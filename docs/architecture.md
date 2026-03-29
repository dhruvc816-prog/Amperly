# 🏗️ Amperly ⚡ - System Architecture

## Overview
Amperly is a smart energy analyzer built using Java 21 and Spring Boot 4.0.4.

## Tech Stack
- **Backend:** Java 21, Spring Boot 4.x
- **Database:** MySQL 8.0
- **APIs:** NASA Power API (Solar Data), Google Gemini API (AI Insights)
- **Security:** Spring Security + JWT

## Layered Architecture
1. **Controller Layer:** REST Endpoints.
2. **Service Layer:** Business Logic (Solar ROI, Bill Parsing).
3. **Repository Layer:** Data persistence via JPA.