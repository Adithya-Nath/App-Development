import Dashboard from './Components/Dashboard';
import Login from './Components/login';
import ProfileDetails from './Components/profileDetails.js';
import Signup from './Components/signup';
import { BrowserRouter, Routes ,Route} from 'react-router-dom';
import Home from './Components/Home';
import FAQ from './Components/faq';
import PrivacyPolicy from './Components/PrivacyPolicy';
import TermsAndConditions from './Components/Terms';
import ContactUs from './Components/ContactUs';
import Recepient from './Components/Recipient';
import Donor from './Components/donor'
function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/' element={<Login />}></Route>
        <Route path='/signup' element={<Signup />}></Route>
        <Route path='/dashboard' element={<Dashboard />}></Route>
        <Route path='/profile' element={<ProfileDetails/>}></Route>
        <Route path='/donor' element={<Donor />}></Route>
        <Route path='/home' element={<Home />}></Route>
        <Route path='/Recipient' element={<Recepient />}></Route>
        <Route path='/faq' element={<FAQ />}></Route>
        <Route path='/PrivacyPolicy' element={<PrivacyPolicy />}></Route>
        <Route path='/Terms' element={<TermsAndConditions/>}></Route>
        <Route path='/ContactUs' element={<ContactUs />}></Route>
        <Route path='/profileDetails' element={<ProfileDetails />}></Route>




      </Routes>
    </BrowserRouter>
    
  );
}

export default App;
