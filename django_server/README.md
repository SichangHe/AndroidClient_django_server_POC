# Django Server

A toy server using SQLite and no package manager.

## Getting Started

1. Manually install required packages.
1. `cd` here.
1. Run the migrations.

    ```shell
    python3 manage.py migrate
    ```

1. See if you can launch the test server.

    ```shell
    python3 manage.py runserver
    ```

1. Create your super user.

    ```shell
    python3 manage.py createsuperuser --email admin@example.com --username admin
    ```

    Use `password` for their password for testing.
1. Test out the demo REST API.

    ```shell
    curl -u admin:password http://127.0.0.1:8000/users/
    ```

## Visual Studio Code plugins

Please use these plugins.

- Code Spell Checker
- Django
- djLint
- Pylance
- Python
