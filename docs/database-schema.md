# 🗄️ Amperly ⚡ - Database Schema

## Tables
1. **users**: ID, Username, Email, Password, State, City.
2. **bills**: ID, User_ID, Month, Units, Amount.
3. **master_tariffs**: ID, State, Rate_Per_Unit, Slab_Details.
4. **solar_analysis**: ID, User_ID, ROI_Data, Irradiance.

## Relationships
- User (1) <---> Bills (Many)
- User (1) <---> Solar_Analysis (Many)