import { Outlet } from 'react-router-dom';
import Nav from './components/Nav';

function App () {
  return (
    <div>
      <Nav />  {/* Navigation bar */}
      <main>
        <Outlet />  {/* Renders the child route component */}
      </main>
    </div>
  );
};

export default App; 
