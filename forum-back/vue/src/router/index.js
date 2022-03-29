import {createRouter, createWebHistory} from 'vue-router'
import Layout from '../layout/Layout.vue'

const routes = [
    {
        path: '/',
        name: 'Layout',
        component: Layout,
        redirect: "/user",
        children: [
            {
                path: 'user',
                name: 'User',
                component: () => import("@/views/User"),
            },
            {
                path: 'person',
                name: 'Person',
                component: () => import("@/views/Person"),
            },
            {
                path: 'topic',
                name: 'Topic',
                component: () => import("@/views/Topic"),
            },
            {
                path: 'answer',
                name: 'Answer',
                component: () => import("@/views/Answer"),
            },
            {
                path: 'image',
                name: 'Image',
                component: () => import("@/views/Image"),
            },
        ]
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import("@/views/Login")
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import("@/views/Register")
    },
]

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export default router
