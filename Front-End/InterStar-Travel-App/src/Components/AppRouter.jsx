import { RouterProvider, createBrowserRouter } from "react-router-dom";
import App from "/src/App";
import NotFound from "./NotFound";
import Landing from "./Landing";
import FlightSearchForm from "./FlightSearchForm";

function AppRouter() {
  const routes = [
    {
      path: "/",
      element: <App />,
      children: [
        {
          path: "/",
          element: <Landing />,
        }, 
        {
          path:"/flights",
          element: <FlightSearchForm />
        }
      ],
    },
  ];

  const router = createBrowserRouter(routes);

  return <RouterProvider router={router} />;
}

export default AppRouter;
