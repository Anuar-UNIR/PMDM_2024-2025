using UnityEngine;

public class Shoot : MonoBehaviour
{

    public GameObject bullet;
    public Transform spawnPoint;

    public float shotForce = 1500f;

    // Start is called once before the first execution of Update after the MonoBehaviour is created
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetButtonDown("Fire1"))
        {
            GameObject newBullet;
            newBullet = Instantiate(bullet, spawnPoint.position, spawnPoint.rotation);

            newBullet.GetComponent<Rigidbody>().AddForce(shotForce * spawnPoint.forward);

            Destroy(newBullet, 5f);

        }
    }
}
