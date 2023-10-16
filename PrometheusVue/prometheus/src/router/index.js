import { createRouter, createWebHashHistory } from "vue-router";
import LandingPage from "../views/LandingPage.vue";
import EditorPage from "../views/EditorPage.vue";

const routes = [
  {
    path: "/",
    name: "landing-page",
    component: LandingPage,
  }, {
    path: "/editor",
    name: "editor-page",
    component: EditorPage,
  },
//  {
//    path: "/about",
//    name: "about",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
//    component: () =>
//      import(/* webpackChunkName: "about" */ "../views/AboutView.vue"),
//  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
