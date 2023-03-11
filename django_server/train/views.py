from django.contrib.auth.models import User
from django.shortcuts import render
from rest_framework import viewsets

from .serializers import UserSerializer


# ViewSets define the view behavior.
class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer
