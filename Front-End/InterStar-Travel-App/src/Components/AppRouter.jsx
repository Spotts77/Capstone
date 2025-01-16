import { RouterProvider, createBrowserRouter } from "react-router-dom";
import App from "/src/App";
import NotFound from "./NotFound";
import Landing from "./Landing";
import DestinationList from "./DestinationList";
import FlightSearchForm from "./FlightSearchForm";
import BookingSearchForm from "./BookingSearchForm";
import FlightList from "./flightList";
import BookingOverview from "./BookingOverview";

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
        },
        {
          path:"/DestinationList",
          element: <DestinationList />
        },
        {
          path:"/BookingSearchForm",
          element: <BookingSearchForm />
        },
        {
          path: "/flightList",
          element: <FlightList />,
        },
        {
          path: "/BookingOverview",
          element: <BookingOverview />,
        }
      ],
    },
  ];

  const router = createBrowserRouter(routes);

  return <RouterProvider router={router} />;
}

export default AppRouter;
