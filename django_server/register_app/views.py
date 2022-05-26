from django.shortcuts import render
from rest_framework import viewsets
from rest_framework.response import Response
from .serializers import AccountsSerializer
from .models import Accounts

class AccountsViewset(viewsets.ModelViewSet):
    queryset = Accounts.objects.all()
    serializer_class = AccountsSerializer
