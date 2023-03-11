from django.urls import path
from train import views

urlpatterns = [path("task", views.task, name="task")]
