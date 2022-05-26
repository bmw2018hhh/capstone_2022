from rest_framework import routers
from login_exam import views
from django.conf.urls import url, include

from django.contrib import admin
from django.urls import path, include


router = routers.DefaultRouter()
router.register(r'posts', views.PostViewset)
router.register(r'accounts', views.AccountsViewset)

urlpatterns = [
    path('admin/', admin.site.urls),
    path('pybo/', include('pybo.urls')),
    url(r'^',include(router.urls)),
    url(r'^api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]