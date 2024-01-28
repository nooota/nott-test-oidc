import React from 'react';
import logo from './logo.svg';
import './App.css';
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";
import { Login } from './pages/login';
import { Page1 } from './pages/Page1';


const router = createBrowserRouter([
  {
    path: "/",
    element: <div>Hello world!</div>,
  },
  {
    path: "/login",
    element: <Login></Login>,
  },
  {
    path: '/page1',
    element: <Page1 />
  }
]);

function App() {
  return (
    <RouterProvider router={router} />
  );
}

export default App;
