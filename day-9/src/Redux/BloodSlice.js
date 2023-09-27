// BloodSlice.js
import { createSlice } from '@reduxjs/toolkit';

const bloodSlice = createSlice({
  name: 'blood',
  initialState: {
    bloodDonationData: null, // Store blood donation details here
  },
  reducers: {
    setBloodDonationData: (state, action) => {
      state.bloodDonationData = action.payload;
    },
  },
});

export const { setBloodDonationData } = bloodSlice.actions;
export const selectBloodDonationData = (state) => state.blood.bloodDonationData; // Export select function

export default bloodSlice.reducer;
