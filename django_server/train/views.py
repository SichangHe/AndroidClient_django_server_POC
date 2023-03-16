import time

from django.contrib.auth.models import User
from django.shortcuts import render
from rest_framework import permissions, viewsets
from rest_framework.decorators import api_view, permission_classes
from rest_framework.request import Request
from rest_framework.response import Response

from .serializers import UserSerializer


# ViewSets define the view behavior.
class UserViewSet(viewsets.ModelViewSet):
    queryset = User.objects.all()
    serializer_class = UserSerializer


# https://www.django-rest-framework.org/api-guide/views/#api_view
@api_view(http_method_names=["GET"])
# https://stackoverflow.com/questions/31335736/cannot-apply-djangomodelpermissions-on-a-view-that-does-not-have-queryset-pro
@permission_classes((permissions.AllowAny,))
def task(request: Request):
    return Response(
        {
            "configuration": {
                "federated_optimizer": "FedAvg",
                "comm_round": 10,
                "epochs": 10,
                "batch_size": 10,
                "client_optimizer": "sgd",
                "learning_rate": 0.1,
                "weight_decay": 0.001,
            },
            "send_time": time.time(),
            "global_weights": [34, 65, 7],
        }
    )


@api_view(http_method_names=["POST"])
@permission_classes((permissions.AllowAny,))
def post(request: Request):
    print(request.data)
    return Response({})
