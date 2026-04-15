package com.example.service.resource

import com.example.service.entity.Item
import com.example.service.repository.ItemRepository
import jakarta.enterprise.context.ApplicationScoped
import jakarta.transaction.Transactional
import jakarta.ws.rs.Consumes
import jakarta.ws.rs.DELETE
import jakarta.ws.rs.GET
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.POST
import jakarta.ws.rs.PUT
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import jakarta.ws.rs.core.Response

@Path("/items")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class ItemResource(private val repository: ItemRepository) {

    @GET
    fun list(): List<Item> = repository.listAll()

    @GET
    @Path("/{id}")
    fun get(@PathParam("id") id: Long): Item =
        repository.findById(id) ?: throw NotFoundException("Item $id not found")

    @POST
    @Transactional
    fun create(item: Item): Response {
        repository.persist(item)
        return Response.status(Response.Status.CREATED).entity(item).build()
    }

    @PUT
    @Path("/{id}")
    @Transactional
    fun update(@PathParam("id") id: Long, updated: Item): Item {
        val item = repository.findById(id) ?: throw NotFoundException("Item $id not found")
        item.name = updated.name
        item.description = updated.description
        return item
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    fun delete(@PathParam("id") id: Long): Response {
        val deleted = repository.deleteById(id)
        return if (deleted) Response.noContent().build()
        else throw NotFoundException("Item $id not found")
    }
}
