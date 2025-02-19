using TMPro;
using UnityEngine;
using UnityEngine.InputSystem;

public class PlayerController2 : MonoBehaviour
{

    private Rigidbody rb;
    private float movementX;
    private float movementY;

    public float speed = 0;

    private int count;

    public TextMeshProUGUI countText;
    public GameObject winTextObject;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {
        rb = GetComponent<Rigidbody>();
        this.count = 0;
        this.SetCountText();
        this.winTextObject.SetActive(false);

    }

    void OnMove(InputValue movementValue)
    {
        Vector2 movementVector = movementValue.Get<Vector2>();
        movementX = movementVector.x;
        movementY = movementVector.y;
    }

    // Update is called once per frame
    void Update()
    {

    }

    // Funcion para actualizar, especialmente diseñada para fisicas o procesos costosos
    private void FixedUpdate()
    {
        Vector3 movementVector = new Vector3(movementX, 0.0f, movementY);
        rb.AddForce(movementVector * speed);

    }

    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("PickUp"))
        {
            other.gameObject.SetActive(false);
            count++;
            this.SetCountText();
        }

    }

    private void OnCollisionEnter(Collision other)
    {
        if (other.gameObject.CompareTag("Enemy"))
        {
            Destroy(gameObject);
            this.winTextObject.gameObject.SetActive(true);
            this.winTextObject.GetComponent<TextMeshProUGUI>().text = "You Lose !!!!";
            Destroy(GameObject.FindGameObjectWithTag("Enemy"));
        }
    }

    void SetCountText()
    {
        this.countText.text = "Puntos: " + this.count.ToString();
        if (this.count >= 8)
        {
            this.winTextObject.SetActive(true);
            Destroy(gameObject);
            Destroy(GameObject.FindGameObjectWithTag("Enemy"));
        }
    }
}
